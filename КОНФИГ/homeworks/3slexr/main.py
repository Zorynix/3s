from sly import Lexer, Parser
import json
import codecs
import sys

class SLexer(Lexer):
    tokens = {NUMBER, STRING, LPAR, RPAR, NAME, LFIG, RFIG, FOR, PATTERN}

    ignore = '\t\r '
    ignore_newline = r'\n+'
    ignore_comment = r'\#.*'

    STRING = r'\"[\w\dа-яА-Я_\-\.\,\s]+\"'
    LPAR = r'\('
    RPAR = r'\)'
    LFIG = r'\{'
    RFIG = r'\}'
    NAME = r'[a-zA-Z_][a-zA-Z0-9_-]+'
    NUMBER = r'\d+'

    NAME["for"] = FOR
    PATTERN = r'\"[\w\dа-яА-Я_\-\.\,\s]+%[\w\dа-яА-Я_\-\.\,\s]*\"'

    @_(r'\d+')
    def NUMBER(self, t):
        t.value = int(t.value)
        return t


class SParser(Parser):
    tokens = SLexer.tokens

    def init(self):
        self.names = {}

    @_('object')
    def program(self, p):
        return p.object

    @_('LPAR s_exp_list RPAR')
    def object(self, p):
        d = {}
        d.update(p.s_exp_list)
        return d

    @_('sexp s_exp_list')
    def s_exp_list(self, p):
        d = {}
        d.update(p.sexp)
        d.update(p.s_exp_list)
        return d

    @_('')
    def s_exp_list(self, p):
        return {}

    @_('NAME LPAR list_value RPAR')
    def sexp(self, p):
        d = {}
        d[p.NAME] = p.list_value
        return d

    @_('value list_value')
    def list_value(self, p):
        if (isinstance(p.list_value, list)):
            if (len(p.list_value) != 0):
                return [p.value] + p.list_value
            return p.value
        return [p.value] + [p.list_value]

    @_('')
    def list_value(self, p):
        return []

    @_('NUMBER')
    def value(self, p):
        return p.NUMBER

    @_('STRING')
    def value(self, p):
        s = p.STRING
        s = s[1:-1]
        return s

    @_('object')
    def value(self, p):
        return p.object

    @_('LFIG PATTERN FOR NUMBER NUMBER RFIG')
    def value(self, p):
        b = p.NUMBER0
        e = p.NUMBER1
        word = p.PATTERN
        word = word[1:-1]
        parts = word.split('%')
        a = []
        for x in range(b, e+1):
            a.append(parts[0] + str(x) + parts[1])
        return a


def parse_config_file(input_file, output_file):
    lexer = SLexer()
    parser = SParser()
    with open(input_file, 'r', encoding='utf-8') as file:
        config_data = file.read()
    result = parser.parse(lexer.tokenize(config_data))

    with open(output_file, 'w', encoding='utf-8') as json_file:
        json.dump(result, json_file, indent=2, ensure_ascii=False)

if __name__ == '__main__':
    import sys

    if len(sys.argv) != 3:
        print("Использование: python main.py <входной файл> <выходной файл>")
        sys.exit(1)
    input_file = sys.argv[1]
    output_file = sys.argv[2]

    parse_config_file(input_file, output_file)
