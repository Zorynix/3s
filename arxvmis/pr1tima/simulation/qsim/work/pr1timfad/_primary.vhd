library verilog;
use verilog.vl_types.all;
entity pr1timfad is
    port(
        Y               : out    vl_logic;
        A               : in     vl_logic;
        B               : in     vl_logic;
        C               : in     vl_logic;
        D               : in     vl_logic
    );
end pr1timfad;
