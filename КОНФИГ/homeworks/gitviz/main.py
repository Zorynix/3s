import sys
import random
from git import Repo
import graphviz


def generate_hex_color():
    red = random.randint(0, 255)
    green = random.randint(0, 255)
    blue = random.randint(0, 255)
    hex_color = '#%02x%02x%02x' % (red, green, blue)
    return hex_color


def main(args):
    if len(args) == 1:
        print("Please, enter abs path to repo")
        sys.exit(1)

    dot = graphviz.Digraph('Graph')
    path = args[1]

    # Получаем список объектов Git
    repo = Repo(path, search_parent_directories=True)

    # Добавляем узел для ветки
    branch_node = f"Branch_{repo.active_branch.name}"
    dot.node(branch_node, label=f"Branch: {repo.active_branch.name}", shape='box')

    # Добавляем узлы и рёбра для каждого коммита и файла
    for commit in repo.iter_commits():
        commit_header = commit.message.split('\n')[0]
        color = generate_hex_color()
        node_id = str(commit)

        # Check if the commit is the HEAD commit
        if node_id == str(repo.head.commit):
            dot.node(node_id,
                     label=f'{commit.author}, date: {commit.authored_date}, header: {commit_header}, hash: {commit.hexsha}',
                     color='orange')
        else:
            dot.node(node_id,
                     label=f'{commit.author}, date: {commit.authored_date}, header: {commit_header}, hash: {commit.hexsha}')

        # Add edge from branch node to commit node
        dot.edge(branch_node, node_id, color=color)

        for el in commit.tree.traverse():
            if el.type == 'blob':
                blob_sha = el.hexsha
                contents = repo.git.cat_file('-p', blob_sha)
                dot.node(str(el.hexsha) + str(commit), label=f'{el.path}\nhash: {blob_sha}\ncontents: {contents}')
                dot.edge(node_id, str(el.hexsha) + str(commit), color=color)

    # Set node attributes
    dot.node_attr["shape"] = "ellipse"

    # Set graph attributes
    dot.graph_attr["rankdir"] = "LR"
    dot.attr(nodesep="2")
    dot.attr(ranksep="20")
    dot.attr(fontsize="20")

    dot.render("repo", view=True, format='svg')


if __name__ == "__main__":
    main(sys.argv)
