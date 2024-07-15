-- Copyright (C) 1991-2013 Altera Corporation
-- Your use of Altera Corporation's design tools, logic functions 
-- and other software and tools, and its AMPP partner logic 
-- functions, and any output files from any of the foregoing 
-- (including device programming or simulation files), and any 
-- associated documentation or information are expressly subject 
-- to the terms and conditions of the Altera Program License 
-- Subscription Agreement, Altera MegaCore Function License 
-- Agreement, or other applicable license agreement, including, 
-- without limitation, that your use is for the sole purpose of 
-- programming logic devices manufactured by Altera and sold by 
-- Altera or its authorized distributors.  Please refer to the 
-- applicable agreement for further details.

-- VENDOR "Altera"
-- PROGRAM "Quartus II 64-Bit"
-- VERSION "Version 13.1.0 Build 162 10/23/2013 SJ Web Edition"

-- DATE "10/05/2023 19:43:01"

-- 
-- Device: Altera EPM240F100C4 Package FBGA100
-- 

-- 
-- This VHDL file should be used for ModelSim-Altera (VHDL) only
-- 

LIBRARY IEEE;
LIBRARY MAXII;
USE IEEE.STD_LOGIC_1164.ALL;
USE MAXII.MAXII_COMPONENTS.ALL;

ENTITY 	praca6 IS
    PORT (
	q : OUT std_logic_vector(3 DOWNTO 0);
	clk : IN std_logic;
	a : IN std_logic;
	b : IN std_logic
	);
END praca6;

-- Design Ports Information
-- q[3]	=>  Location: PIN_J6,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
-- q[2]	=>  Location: PIN_J8,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
-- q[1]	=>  Location: PIN_H7,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
-- q[0]	=>  Location: PIN_K8,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
-- b	=>  Location: PIN_K9,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
-- a	=>  Location: PIN_K7,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
-- clk	=>  Location: PIN_E1,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default


ARCHITECTURE structure OF praca6 IS
SIGNAL gnd : std_logic := '0';
SIGNAL vcc : std_logic := '1';
SIGNAL unknown : std_logic := 'X';
SIGNAL devoe : std_logic := '1';
SIGNAL devclrn : std_logic := '1';
SIGNAL devpor : std_logic := '1';
SIGNAL ww_devoe : std_logic;
SIGNAL ww_devclrn : std_logic;
SIGNAL ww_devpor : std_logic;
SIGNAL ww_q : std_logic_vector(3 DOWNTO 0);
SIGNAL ww_clk : std_logic;
SIGNAL ww_a : std_logic;
SIGNAL ww_b : std_logic;
SIGNAL \clk~combout\ : std_logic;
SIGNAL \1~5_combout\ : std_logic;
SIGNAL \a~combout\ : std_logic;
SIGNAL \1~4_combout\ : std_logic;
SIGNAL \1~3_combout\ : std_logic;
SIGNAL \1~6_combout\ : std_logic;
SIGNAL \inst19~3_combout\ : std_logic;
SIGNAL \inst21~3_combout\ : std_logic;
SIGNAL \inst7~regout\ : std_logic;
SIGNAL \1~0_combout\ : std_logic;
SIGNAL \inst1~3_combout\ : std_logic;
SIGNAL \b~combout\ : std_logic;
SIGNAL \inst1~2_combout\ : std_logic;
SIGNAL \inst1~5_combout\ : std_logic;
SIGNAL \inst6~regout\ : std_logic;
SIGNAL \inst5~regout\ : std_logic;
SIGNAL \1~2_combout\ : std_logic;
SIGNAL \1~1_combout\ : std_logic;
SIGNAL \inst19~2_combout\ : std_logic;
SIGNAL \inst19~5_combout\ : std_logic;
SIGNAL \inst8~regout\ : std_logic;

BEGIN

q <= ww_q;
ww_clk <= clk;
ww_a <= a;
ww_b <= b;
ww_devoe <= devoe;
ww_devclrn <= devclrn;
ww_devpor <= devpor;

-- Location: PIN_E1,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\clk~I\ : maxii_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_clk,
	combout => \clk~combout\);

-- Location: LC_X5_Y1_N9
\1~5\ : maxii_lcell
-- Equation(s):
-- \1~5_combout\ = (\inst8~regout\ & (!\inst6~regout\ & (\inst7~regout\ & \inst5~regout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "2000",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \inst8~regout\,
	datab => \inst6~regout\,
	datac => \inst7~regout\,
	datad => \inst5~regout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \1~5_combout\);

-- Location: PIN_K7,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a~I\ : maxii_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a,
	combout => \a~combout\);

-- Location: LC_X5_Y1_N2
\1~4\ : maxii_lcell
-- Equation(s):
-- \1~4_combout\ = (!\inst6~regout\ & (!\inst7~regout\ & (\inst8~regout\ & !\inst5~regout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0010",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \inst6~regout\,
	datab => \inst7~regout\,
	datac => \inst8~regout\,
	datad => \inst5~regout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \1~4_combout\);

-- Location: LC_X5_Y1_N5
\1~3\ : maxii_lcell
-- Equation(s):
-- \1~3_combout\ = (!\inst6~regout\ & (!\inst7~regout\ & (!\inst8~regout\ & \inst5~regout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0100",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \inst6~regout\,
	datab => \inst7~regout\,
	datac => \inst8~regout\,
	datad => \inst5~regout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \1~3_combout\);

-- Location: LC_X5_Y1_N3
\1~6\ : maxii_lcell
-- Equation(s):
-- \1~6_combout\ = (!\inst6~regout\ & (!\inst7~regout\ & (\inst8~regout\ & \inst5~regout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1000",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \inst6~regout\,
	datab => \inst7~regout\,
	datac => \inst8~regout\,
	datad => \inst5~regout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \1~6_combout\);

-- Location: LC_X5_Y1_N4
\inst19~3\ : maxii_lcell
-- Equation(s):
-- \inst19~3_combout\ = (!\1~4_combout\ & (!\1~3_combout\ & ((\a~combout\) # (!\1~6_combout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0203",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \a~combout\,
	datab => \1~4_combout\,
	datac => \1~3_combout\,
	datad => \1~6_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \inst19~3_combout\);

-- Location: LC_X5_Y1_N0
\inst21~3\ : maxii_lcell
-- Equation(s):
-- \inst21~3_combout\ = (\inst6~regout\ & ((\inst5~regout\) # (\inst8~regout\ $ (!\inst7~regout\)))) # (!\inst6~regout\ & ((\inst8~regout\) # ((!\inst7~regout\ & \inst5~regout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "efa6",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \inst8~regout\,
	datab => \inst6~regout\,
	datac => \inst7~regout\,
	datad => \inst5~regout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \inst21~3_combout\);

-- Location: LC_X5_Y1_N1
inst7 : maxii_lcell
-- Equation(s):
-- \inst7~regout\ = DFFEAS(((\1~5_combout\) # ((!\inst21~3_combout\) # (!\inst19~3_combout\))), GLOBAL(\clk~combout\), VCC, , , , , , )

-- pragma translate_off
GENERIC MAP (
	lut_mask => "cfff",
	operation_mode => "normal",
	output_mode => "reg_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	clk => \clk~combout\,
	datab => \1~5_combout\,
	datac => \inst19~3_combout\,
	datad => \inst21~3_combout\,
	aclr => GND,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	regout => \inst7~regout\);

-- Location: LC_X5_Y1_N6
\1~0\ : maxii_lcell
-- Equation(s):
-- \1~0_combout\ = (\inst8~regout\ & (!\inst6~regout\ & (\inst7~regout\ & !\inst5~regout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0020",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \inst8~regout\,
	datab => \inst6~regout\,
	datac => \inst7~regout\,
	datad => \inst5~regout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \1~0_combout\);

-- Location: LC_X5_Y1_N7
\inst1~3\ : maxii_lcell
-- Equation(s):
-- \inst1~3_combout\ = ((!\1~4_combout\ & ((\a~combout\) # (!\1~6_combout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "3033",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \1~4_combout\,
	datac => \a~combout\,
	datad => \1~6_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \inst1~3_combout\);

-- Location: PIN_K9,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b~I\ : maxii_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b,
	combout => \b~combout\);

-- Location: LC_X6_Y1_N7
\inst1~2\ : maxii_lcell
-- Equation(s):
-- \inst1~2_combout\ = (\inst5~regout\ & (!\inst6~regout\ & ((!\b~combout\) # (!\inst8~regout\)))) # (!\inst5~regout\ & (\inst8~regout\ & ((\inst6~regout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0a70",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \inst8~regout\,
	datab => \b~combout\,
	datac => \inst5~regout\,
	datad => \inst6~regout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \inst1~2_combout\);

-- Location: LC_X6_Y1_N8
\inst1~5\ : maxii_lcell
-- Equation(s):
-- \inst1~5_combout\ = (((\inst7~regout\ & \inst1~2_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "f000",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datac => \inst7~regout\,
	datad => \inst1~2_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \inst1~5_combout\);

-- Location: LC_X5_Y1_N8
inst6 : maxii_lcell
-- Equation(s):
-- \inst6~regout\ = DFFEAS((\1~0_combout\) # ((\1~2_combout\) # ((\inst1~5_combout\) # (!\inst1~3_combout\))), GLOBAL(\clk~combout\), VCC, , , , , , )

-- pragma translate_off
GENERIC MAP (
	lut_mask => "ffef",
	operation_mode => "normal",
	output_mode => "reg_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	clk => \clk~combout\,
	dataa => \1~0_combout\,
	datab => \1~2_combout\,
	datac => \inst1~3_combout\,
	datad => \inst1~5_combout\,
	aclr => GND,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	regout => \inst6~regout\);

-- Location: LC_X6_Y1_N4
inst5 : maxii_lcell
-- Equation(s):
-- \inst5~regout\ = DFFEAS((\inst5~regout\ & (!\inst6~regout\ & (\inst8~regout\ $ (\inst7~regout\)))) # (!\inst5~regout\ & ((\inst6~regout\ $ (\inst7~regout\)) # (!\inst8~regout\))), GLOBAL(\clk~combout\), VCC, , , , , , )

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1763",
	operation_mode => "normal",
	output_mode => "reg_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	clk => \clk~combout\,
	dataa => \inst6~regout\,
	datab => \inst5~regout\,
	datac => \inst8~regout\,
	datad => \inst7~regout\,
	aclr => GND,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	regout => \inst5~regout\);

-- Location: LC_X6_Y1_N5
\1~2\ : maxii_lcell
-- Equation(s):
-- \1~2_combout\ = (\inst8~regout\ & (\inst5~regout\ & (\inst7~regout\ & \inst6~regout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "8000",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \inst8~regout\,
	datab => \inst5~regout\,
	datac => \inst7~regout\,
	datad => \inst6~regout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \1~2_combout\);

-- Location: LC_X6_Y1_N2
\1~1\ : maxii_lcell
-- Equation(s):
-- \1~1_combout\ = (\inst7~regout\ & (\inst5~regout\ & (\inst6~regout\ & !\inst8~regout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0080",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \inst7~regout\,
	datab => \inst5~regout\,
	datac => \inst6~regout\,
	datad => \inst8~regout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \1~1_combout\);

-- Location: LC_X6_Y1_N9
\inst19~2\ : maxii_lcell
-- Equation(s):
-- \inst19~2_combout\ = (\inst7~regout\ & (\inst8~regout\ & (!\b~combout\ & !\inst6~regout\))) # (!\inst7~regout\ & (((\inst6~regout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0f20",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \inst8~regout\,
	datab => \b~combout\,
	datac => \inst7~regout\,
	datad => \inst6~regout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \inst19~2_combout\);

-- Location: LC_X6_Y1_N0
\inst19~5\ : maxii_lcell
-- Equation(s):
-- \inst19~5_combout\ = (((!\inst5~regout\ & \inst19~2_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0f00",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datac => \inst5~regout\,
	datad => \inst19~2_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \inst19~5_combout\);

-- Location: LC_X6_Y1_N6
inst8 : maxii_lcell
-- Equation(s):
-- \inst8~regout\ = DFFEAS((\1~2_combout\) # ((\1~1_combout\) # ((\inst19~5_combout\) # (!\inst19~3_combout\))), GLOBAL(\clk~combout\), VCC, , , , , , )

-- pragma translate_off
GENERIC MAP (
	lut_mask => "feff",
	operation_mode => "normal",
	output_mode => "reg_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	clk => \clk~combout\,
	dataa => \1~2_combout\,
	datab => \1~1_combout\,
	datac => \inst19~5_combout\,
	datad => \inst19~3_combout\,
	aclr => GND,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	regout => \inst8~regout\);

-- Location: PIN_J6,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\q[3]~I\ : maxii_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \inst8~regout\,
	oe => VCC,
	padio => ww_q(3));

-- Location: PIN_J8,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\q[2]~I\ : maxii_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \inst7~regout\,
	oe => VCC,
	padio => ww_q(2));

-- Location: PIN_H7,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\q[1]~I\ : maxii_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \inst6~regout\,
	oe => VCC,
	padio => ww_q(1));

-- Location: PIN_K8,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\q[0]~I\ : maxii_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \inst5~regout\,
	oe => VCC,
	padio => ww_q(0));
END structure;


