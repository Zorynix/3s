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

-- DATE "10/05/2023 23:07:00"

-- 
-- Device: Altera EP4CGX15BF14C6 Package FBGA169
-- 

-- 
-- This VHDL file should be used for ModelSim-Altera (VHDL) only
-- 

LIBRARY CYCLONEIV;
LIBRARY IEEE;
USE CYCLONEIV.CYCLONEIV_COMPONENTS.ALL;
USE IEEE.STD_LOGIC_1164.ALL;

ENTITY 	pract7 IS
    PORT (
	a : IN std_logic;
	b : IN std_logic;
	clk : IN std_logic;
	newq0 : OUT std_logic;
	newq1 : OUT std_logic;
	newq2 : OUT std_logic;
	newq3 : OUT std_logic;
	st15 : OUT std_logic;
	st14 : OUT std_logic;
	st13 : OUT std_logic;
	st12 : OUT std_logic;
	st11 : OUT std_logic;
	st10 : OUT std_logic;
	st9 : OUT std_logic;
	st8 : OUT std_logic;
	st7 : OUT std_logic;
	st6 : OUT std_logic;
	st5 : OUT std_logic;
	st4 : OUT std_logic;
	st3 : OUT std_logic;
	st2 : OUT std_logic;
	st1 : OUT std_logic;
	st0 : OUT std_logic;
	r0 : OUT std_logic;
	r1 : OUT std_logic;
	r2 : OUT std_logic;
	r3 : OUT std_logic;
	r4 : OUT std_logic;
	r5 : OUT std_logic;
	q : OUT std_logic_vector(3 DOWNTO 0)
	);
END pract7;

-- Design Ports Information
-- newq0	=>  Location: PIN_L7,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- newq1	=>  Location: PIN_H12,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- newq2	=>  Location: PIN_N8,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- newq3	=>  Location: PIN_K8,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st15	=>  Location: PIN_L13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st14	=>  Location: PIN_K10,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st13	=>  Location: PIN_N9,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st12	=>  Location: PIN_M11,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st11	=>  Location: PIN_L12,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st10	=>  Location: PIN_N6,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st9	=>  Location: PIN_L4,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st8	=>  Location: PIN_L5,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st7	=>  Location: PIN_M13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st6	=>  Location: PIN_C8,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st5	=>  Location: PIN_M9,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st4	=>  Location: PIN_B11,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st3	=>  Location: PIN_B10,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st2	=>  Location: PIN_M6,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st1	=>  Location: PIN_M4,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- st0	=>  Location: PIN_H10,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- r0	=>  Location: PIN_J13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- r1	=>  Location: PIN_N4,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- r2	=>  Location: PIN_N13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- r3	=>  Location: PIN_L11,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- r4	=>  Location: PIN_K11,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- r5	=>  Location: PIN_K12,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- q[0]	=>  Location: PIN_L9,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- q[1]	=>  Location: PIN_N11,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- q[2]	=>  Location: PIN_N12,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- q[3]	=>  Location: PIN_F9,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- clk	=>  Location: PIN_K9,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- b	=>  Location: PIN_N10,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- a	=>  Location: PIN_C6,	 I/O Standard: 2.5 V,	 Current Strength: Default


ARCHITECTURE structure OF pract7 IS
SIGNAL gnd : std_logic := '0';
SIGNAL vcc : std_logic := '1';
SIGNAL unknown : std_logic := 'X';
SIGNAL devoe : std_logic := '1';
SIGNAL devclrn : std_logic := '1';
SIGNAL devpor : std_logic := '1';
SIGNAL ww_devoe : std_logic;
SIGNAL ww_devclrn : std_logic;
SIGNAL ww_devpor : std_logic;
SIGNAL ww_a : std_logic;
SIGNAL ww_b : std_logic;
SIGNAL ww_clk : std_logic;
SIGNAL ww_newq0 : std_logic;
SIGNAL ww_newq1 : std_logic;
SIGNAL ww_newq2 : std_logic;
SIGNAL ww_newq3 : std_logic;
SIGNAL ww_st15 : std_logic;
SIGNAL ww_st14 : std_logic;
SIGNAL ww_st13 : std_logic;
SIGNAL ww_st12 : std_logic;
SIGNAL ww_st11 : std_logic;
SIGNAL ww_st10 : std_logic;
SIGNAL ww_st9 : std_logic;
SIGNAL ww_st8 : std_logic;
SIGNAL ww_st7 : std_logic;
SIGNAL ww_st6 : std_logic;
SIGNAL ww_st5 : std_logic;
SIGNAL ww_st4 : std_logic;
SIGNAL ww_st3 : std_logic;
SIGNAL ww_st2 : std_logic;
SIGNAL ww_st1 : std_logic;
SIGNAL ww_st0 : std_logic;
SIGNAL ww_r0 : std_logic;
SIGNAL ww_r1 : std_logic;
SIGNAL ww_r2 : std_logic;
SIGNAL ww_r3 : std_logic;
SIGNAL ww_r4 : std_logic;
SIGNAL ww_r5 : std_logic;
SIGNAL ww_q : std_logic_vector(3 DOWNTO 0);
SIGNAL \newq0~output_o\ : std_logic;
SIGNAL \newq1~output_o\ : std_logic;
SIGNAL \newq2~output_o\ : std_logic;
SIGNAL \newq3~output_o\ : std_logic;
SIGNAL \st15~output_o\ : std_logic;
SIGNAL \st14~output_o\ : std_logic;
SIGNAL \st13~output_o\ : std_logic;
SIGNAL \st12~output_o\ : std_logic;
SIGNAL \st11~output_o\ : std_logic;
SIGNAL \st10~output_o\ : std_logic;
SIGNAL \st9~output_o\ : std_logic;
SIGNAL \st8~output_o\ : std_logic;
SIGNAL \st7~output_o\ : std_logic;
SIGNAL \st6~output_o\ : std_logic;
SIGNAL \st5~output_o\ : std_logic;
SIGNAL \st4~output_o\ : std_logic;
SIGNAL \st3~output_o\ : std_logic;
SIGNAL \st2~output_o\ : std_logic;
SIGNAL \st1~output_o\ : std_logic;
SIGNAL \st0~output_o\ : std_logic;
SIGNAL \r0~output_o\ : std_logic;
SIGNAL \r1~output_o\ : std_logic;
SIGNAL \r2~output_o\ : std_logic;
SIGNAL \r3~output_o\ : std_logic;
SIGNAL \r4~output_o\ : std_logic;
SIGNAL \r5~output_o\ : std_logic;
SIGNAL \q[0]~output_o\ : std_logic;
SIGNAL \q[1]~output_o\ : std_logic;
SIGNAL \q[2]~output_o\ : std_logic;
SIGNAL \q[3]~output_o\ : std_logic;
SIGNAL \clk~input_o\ : std_logic;
SIGNAL \_~3_combout\ : std_logic;
SIGNAL \st12~1_combout\ : std_logic;
SIGNAL \b~input_o\ : std_logic;
SIGNAL \r5~0_combout\ : std_logic;
SIGNAL \st14~0_combout\ : std_logic;
SIGNAL \st5~0_combout\ : std_logic;
SIGNAL \st13~0_combout\ : std_logic;
SIGNAL \r2~0_combout\ : std_logic;
SIGNAL \newq1~0_combout\ : std_logic;
SIGNAL \a~input_o\ : std_logic;
SIGNAL \st9~0_combout\ : std_logic;
SIGNAL \r0~0_combout\ : std_logic;
SIGNAL \r4~0_combout\ : std_logic;
SIGNAL \st15~0_combout\ : std_logic;
SIGNAL \newq3~0_combout\ : std_logic;
SIGNAL \_~5_combout\ : std_logic;
SIGNAL \st8~0_combout\ : std_logic;
SIGNAL \st1~0_combout\ : std_logic;
SIGNAL \newq2~2_combout\ : std_logic;
SIGNAL \_~6_combout\ : std_logic;
SIGNAL \newq3~1_combout\ : std_logic;
SIGNAL \_~4_combout\ : std_logic;
SIGNAL \newq0~1_combout\ : std_logic;
SIGNAL \st10~0_combout\ : std_logic;
SIGNAL \newq0~2_combout\ : std_logic;
SIGNAL \newq0~3_combout\ : std_logic;
SIGNAL \st2~0_combout\ : std_logic;
SIGNAL \newq0~4_combout\ : std_logic;
SIGNAL \newq1~1_combout\ : std_logic;
SIGNAL \newq2~3_combout\ : std_logic;
SIGNAL \newq3~2_combout\ : std_logic;
SIGNAL \st11~0_combout\ : std_logic;
SIGNAL \st7~0_combout\ : std_logic;
SIGNAL \st6~0_combout\ : std_logic;
SIGNAL \st4~1_combout\ : std_logic;
SIGNAL \st3~0_combout\ : std_logic;
SIGNAL \st0~0_combout\ : std_logic;
SIGNAL \r1~0_combout\ : std_logic;
SIGNAL \r3~0_combout\ : std_logic;
SIGNAL \ALT_INV_st15~0_combout\ : std_logic;
SIGNAL \ALT_INV__~3_combout\ : std_logic;
SIGNAL \ALT_INV__~6_combout\ : std_logic;
SIGNAL \ALT_INV__~5_combout\ : std_logic;
SIGNAL \ALT_INV__~4_combout\ : std_logic;

BEGIN

ww_a <= a;
ww_b <= b;
ww_clk <= clk;
newq0 <= ww_newq0;
newq1 <= ww_newq1;
newq2 <= ww_newq2;
newq3 <= ww_newq3;
st15 <= ww_st15;
st14 <= ww_st14;
st13 <= ww_st13;
st12 <= ww_st12;
st11 <= ww_st11;
st10 <= ww_st10;
st9 <= ww_st9;
st8 <= ww_st8;
st7 <= ww_st7;
st6 <= ww_st6;
st5 <= ww_st5;
st4 <= ww_st4;
st3 <= ww_st3;
st2 <= ww_st2;
st1 <= ww_st1;
st0 <= ww_st0;
r0 <= ww_r0;
r1 <= ww_r1;
r2 <= ww_r2;
r3 <= ww_r3;
r4 <= ww_r4;
r5 <= ww_r5;
q <= ww_q;
ww_devoe <= devoe;
ww_devclrn <= devclrn;
ww_devpor <= devpor;
\ALT_INV_st15~0_combout\ <= NOT \st15~0_combout\;
\ALT_INV__~3_combout\ <= NOT \_~3_combout\;
\ALT_INV__~6_combout\ <= NOT \_~6_combout\;
\ALT_INV__~5_combout\ <= NOT \_~5_combout\;
\ALT_INV__~4_combout\ <= NOT \_~4_combout\;

-- Location: IOOBUF_X14_Y0_N2
\newq0~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \newq0~4_combout\,
	devoe => ww_devoe,
	o => \newq0~output_o\);

-- Location: IOOBUF_X33_Y14_N9
\newq1~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \newq1~1_combout\,
	devoe => ww_devoe,
	o => \newq1~output_o\);

-- Location: IOOBUF_X20_Y0_N9
\newq2~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \newq2~3_combout\,
	devoe => ww_devoe,
	o => \newq2~output_o\);

-- Location: IOOBUF_X22_Y0_N9
\newq3~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \newq3~2_combout\,
	devoe => ww_devoe,
	o => \newq3~output_o\);

-- Location: IOOBUF_X33_Y12_N9
\st15~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \ALT_INV_st15~0_combout\,
	devoe => ww_devoe,
	o => \st15~output_o\);

-- Location: IOOBUF_X31_Y0_N9
\st14~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st14~0_combout\,
	devoe => ww_devoe,
	o => \st14~output_o\);

-- Location: IOOBUF_X20_Y0_N2
\st13~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st13~0_combout\,
	devoe => ww_devoe,
	o => \st13~output_o\);

-- Location: IOOBUF_X29_Y0_N9
\st12~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st12~1_combout\,
	devoe => ww_devoe,
	o => \st12~output_o\);

-- Location: IOOBUF_X33_Y12_N2
\st11~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st11~0_combout\,
	devoe => ww_devoe,
	o => \st11~output_o\);

-- Location: IOOBUF_X12_Y0_N2
\st10~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st10~0_combout\,
	devoe => ww_devoe,
	o => \st10~output_o\);

-- Location: IOOBUF_X8_Y0_N9
\st9~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st9~0_combout\,
	devoe => ww_devoe,
	o => \st9~output_o\);

-- Location: IOOBUF_X14_Y0_N9
\st8~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st8~0_combout\,
	devoe => ww_devoe,
	o => \st8~output_o\);

-- Location: IOOBUF_X33_Y10_N2
\st7~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st7~0_combout\,
	devoe => ww_devoe,
	o => \st7~output_o\);

-- Location: IOOBUF_X22_Y31_N9
\st6~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st6~0_combout\,
	devoe => ww_devoe,
	o => \st6~output_o\);

-- Location: IOOBUF_X24_Y0_N2
\st5~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st5~0_combout\,
	devoe => ww_devoe,
	o => \st5~output_o\);

-- Location: IOOBUF_X24_Y31_N2
\st4~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st4~1_combout\,
	devoe => ww_devoe,
	o => \st4~output_o\);

-- Location: IOOBUF_X24_Y31_N9
\st3~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st3~0_combout\,
	devoe => ww_devoe,
	o => \st3~output_o\);

-- Location: IOOBUF_X12_Y0_N9
\st2~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st2~0_combout\,
	devoe => ww_devoe,
	o => \st2~output_o\);

-- Location: IOOBUF_X8_Y0_N2
\st1~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st1~0_combout\,
	devoe => ww_devoe,
	o => \st1~output_o\);

-- Location: IOOBUF_X33_Y14_N2
\st0~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \st0~0_combout\,
	devoe => ww_devoe,
	o => \st0~output_o\);

-- Location: IOOBUF_X33_Y15_N9
\r0~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \r0~0_combout\,
	devoe => ww_devoe,
	o => \r0~output_o\);

-- Location: IOOBUF_X10_Y0_N9
\r1~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \r1~0_combout\,
	devoe => ww_devoe,
	o => \r1~output_o\);

-- Location: IOOBUF_X33_Y10_N9
\r2~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \r2~0_combout\,
	devoe => ww_devoe,
	o => \r2~output_o\);

-- Location: IOOBUF_X31_Y0_N2
\r3~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \r3~0_combout\,
	devoe => ww_devoe,
	o => \r3~output_o\);

-- Location: IOOBUF_X33_Y11_N2
\r4~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \r4~0_combout\,
	devoe => ww_devoe,
	o => \r4~output_o\);

-- Location: IOOBUF_X33_Y11_N9
\r5~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \r5~0_combout\,
	devoe => ww_devoe,
	o => \r5~output_o\);

-- Location: IOOBUF_X24_Y0_N9
\q[0]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \ALT_INV__~3_combout\,
	devoe => ww_devoe,
	o => \q[0]~output_o\);

-- Location: IOOBUF_X26_Y0_N2
\q[1]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \ALT_INV__~5_combout\,
	devoe => ww_devoe,
	o => \q[1]~output_o\);

-- Location: IOOBUF_X29_Y0_N2
\q[2]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \ALT_INV__~6_combout\,
	devoe => ww_devoe,
	o => \q[2]~output_o\);

-- Location: IOOBUF_X33_Y25_N2
\q[3]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \ALT_INV__~4_combout\,
	devoe => ww_devoe,
	o => \q[3]~output_o\);

-- Location: IOIBUF_X22_Y0_N1
\clk~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_clk,
	o => \clk~input_o\);

-- Location: LCCOMB_X17_Y1_N24
\_~3\ : cycloneiv_lcell_comb
-- Equation(s):
-- \_~3_combout\ = (\newq0~4_combout\ & \clk~input_o\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1010000010100000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \newq0~4_combout\,
	datac => \clk~input_o\,
	combout => \_~3_combout\);

-- Location: LCCOMB_X17_Y1_N18
\st12~1\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st12~1_combout\ = (!\_~4_combout\ & (\_~3_combout\ & (!\_~6_combout\ & \_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000010000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~4_combout\,
	datab => \_~3_combout\,
	datac => \_~6_combout\,
	datad => \_~5_combout\,
	combout => \st12~1_combout\);

-- Location: IOIBUF_X26_Y0_N8
\b~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_b,
	o => \b~input_o\);

-- Location: LCCOMB_X25_Y4_N22
\r5~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \r5~0_combout\ = (\st12~1_combout\ & \b~input_o\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \st12~1_combout\,
	datad => \b~input_o\,
	combout => \r5~0_combout\);

-- Location: LCCOMB_X25_Y4_N0
\st14~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st14~0_combout\ = (!\_~6_combout\ & (\_~3_combout\ & (!\_~4_combout\ & !\_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000000000100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~6_combout\,
	datab => \_~3_combout\,
	datac => \_~4_combout\,
	datad => \_~5_combout\,
	combout => \st14~0_combout\);

-- Location: LCCOMB_X25_Y4_N8
\st5~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st5~0_combout\ = (!\_~6_combout\ & (!\_~3_combout\ & (\_~4_combout\ & \_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0001000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~6_combout\,
	datab => \_~3_combout\,
	datac => \_~4_combout\,
	datad => \_~5_combout\,
	combout => \st5~0_combout\);

-- Location: LCCOMB_X25_Y4_N26
\st13~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st13~0_combout\ = (!\_~6_combout\ & (!\_~3_combout\ & (!\_~4_combout\ & \_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000100000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~6_combout\,
	datab => \_~3_combout\,
	datac => \_~4_combout\,
	datad => \_~5_combout\,
	combout => \st13~0_combout\);

-- Location: LCCOMB_X25_Y4_N20
\r2~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \r2~0_combout\ = (\st13~0_combout\ & !\b~input_o\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000011110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \st13~0_combout\,
	datad => \b~input_o\,
	combout => \r2~0_combout\);

-- Location: LCCOMB_X25_Y4_N10
\newq1~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \newq1~0_combout\ = (\r5~0_combout\) # ((\st14~0_combout\) # ((\st5~0_combout\) # (\r2~0_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111111111111110",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \r5~0_combout\,
	datab => \st14~0_combout\,
	datac => \st5~0_combout\,
	datad => \r2~0_combout\,
	combout => \newq1~0_combout\);

-- Location: IOIBUF_X14_Y31_N1
\a~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_a,
	o => \a~input_o\);

-- Location: LCCOMB_X17_Y1_N28
\st9~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st9~0_combout\ = (!\_~4_combout\ & (!\_~3_combout\ & (\_~6_combout\ & \_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0001000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~4_combout\,
	datab => \_~3_combout\,
	datac => \_~6_combout\,
	datad => \_~5_combout\,
	combout => \st9~0_combout\);

-- Location: LCCOMB_X17_Y1_N30
\r0~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \r0~0_combout\ = (!\a~input_o\ & \st9~0_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000111100000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \a~input_o\,
	datad => \st9~0_combout\,
	combout => \r0~0_combout\);

-- Location: LCCOMB_X25_Y4_N14
\r4~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \r4~0_combout\ = (\st12~1_combout\ & !\b~input_o\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000011110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \st12~1_combout\,
	datad => \b~input_o\,
	combout => \r4~0_combout\);

-- Location: LCCOMB_X25_Y4_N28
\st15~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st15~0_combout\ = (\_~6_combout\) # ((\_~3_combout\) # ((\_~4_combout\) # (\_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111111111111110",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~6_combout\,
	datab => \_~3_combout\,
	datac => \_~4_combout\,
	datad => \_~5_combout\,
	combout => \st15~0_combout\);

-- Location: LCCOMB_X25_Y4_N16
\newq3~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \newq3~0_combout\ = (!\st8~0_combout\ & (!\r0~0_combout\ & (!\r4~0_combout\ & \st15~0_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000100000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \st8~0_combout\,
	datab => \r0~0_combout\,
	datac => \r4~0_combout\,
	datad => \st15~0_combout\,
	combout => \newq3~0_combout\);

-- Location: LCCOMB_X25_Y4_N6
\_~5\ : cycloneiv_lcell_comb
-- Equation(s):
-- \_~5_combout\ = (\clk~input_o\ & ((\newq1~0_combout\) # (!\newq3~0_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1010000011110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \newq1~0_combout\,
	datac => \clk~input_o\,
	datad => \newq3~0_combout\,
	combout => \_~5_combout\);

-- Location: LCCOMB_X17_Y1_N16
\st8~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st8~0_combout\ = (!\_~4_combout\ & (\_~3_combout\ & (\_~6_combout\ & \_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0100000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~4_combout\,
	datab => \_~3_combout\,
	datac => \_~6_combout\,
	datad => \_~5_combout\,
	combout => \st8~0_combout\);

-- Location: LCCOMB_X17_Y1_N2
\st1~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st1~0_combout\ = (\_~4_combout\ & (!\_~3_combout\ & (\_~6_combout\ & \_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0010000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~4_combout\,
	datab => \_~3_combout\,
	datac => \_~6_combout\,
	datad => \_~5_combout\,
	combout => \st1~0_combout\);

-- Location: LCCOMB_X17_Y1_N12
\newq2~2\ : cycloneiv_lcell_comb
-- Equation(s):
-- \newq2~2_combout\ = (\st8~0_combout\) # ((\st1~0_combout\) # (\st13~0_combout\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111111111111100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \st8~0_combout\,
	datac => \st1~0_combout\,
	datad => \st13~0_combout\,
	combout => \newq2~2_combout\);

-- Location: LCCOMB_X17_Y1_N4
\_~6\ : cycloneiv_lcell_comb
-- Equation(s):
-- \_~6_combout\ = (\clk~input_o\ & ((\newq2~2_combout\) # (!\newq0~2_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1000100011001100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \newq2~2_combout\,
	datab => \clk~input_o\,
	datad => \newq0~2_combout\,
	combout => \_~6_combout\);

-- Location: LCCOMB_X25_Y4_N12
\newq3~1\ : cycloneiv_lcell_comb
-- Equation(s):
-- \newq3~1_combout\ = (\_~3_combout\ & (\_~6_combout\ & ((!\_~5_combout\)))) # (!\_~3_combout\ & (\_~4_combout\ & (\_~6_combout\ $ (!\_~5_combout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0010000010011000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~6_combout\,
	datab => \_~3_combout\,
	datac => \_~4_combout\,
	datad => \_~5_combout\,
	combout => \newq3~1_combout\);

-- Location: LCCOMB_X25_Y4_N4
\_~4\ : cycloneiv_lcell_comb
-- Equation(s):
-- \_~4_combout\ = (\clk~input_o\ & ((\newq3~1_combout\) # (!\newq3~0_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1010000011110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \newq3~1_combout\,
	datac => \clk~input_o\,
	datad => \newq3~0_combout\,
	combout => \_~4_combout\);

-- Location: LCCOMB_X17_Y1_N6
\newq0~1\ : cycloneiv_lcell_comb
-- Equation(s):
-- \newq0~1_combout\ = ((\_~3_combout\ & (\_~6_combout\ & !\_~5_combout\)) # (!\_~3_combout\ & ((\_~6_combout\) # (!\_~5_combout\)))) # (!\_~4_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0111010111110111",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~4_combout\,
	datab => \_~3_combout\,
	datac => \_~6_combout\,
	datad => \_~5_combout\,
	combout => \newq0~1_combout\);

-- Location: LCCOMB_X17_Y1_N0
\st10~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st10~0_combout\ = (!\_~4_combout\ & (\_~3_combout\ & (\_~6_combout\ & !\_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000001000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~4_combout\,
	datab => \_~3_combout\,
	datac => \_~6_combout\,
	datad => \_~5_combout\,
	combout => \st10~0_combout\);

-- Location: LCCOMB_X17_Y1_N10
\newq0~2\ : cycloneiv_lcell_comb
-- Equation(s):
-- \newq0~2_combout\ = (\newq0~1_combout\ & (!\st10~0_combout\ & ((\a~input_o\) # (!\st9~0_combout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0010000000100010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \newq0~1_combout\,
	datab => \st10~0_combout\,
	datac => \a~input_o\,
	datad => \st9~0_combout\,
	combout => \newq0~2_combout\);

-- Location: LCCOMB_X17_Y1_N8
\newq0~3\ : cycloneiv_lcell_comb
-- Equation(s):
-- \newq0~3_combout\ = (\st12~1_combout\) # ((\a~input_o\ & \st9~0_combout\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111110011001100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \st12~1_combout\,
	datac => \a~input_o\,
	datad => \st9~0_combout\,
	combout => \newq0~3_combout\);

-- Location: LCCOMB_X17_Y1_N20
\st2~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st2~0_combout\ = (\_~4_combout\ & (\_~3_combout\ & (\_~6_combout\ & !\_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000010000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~4_combout\,
	datab => \_~3_combout\,
	datac => \_~6_combout\,
	datad => \_~5_combout\,
	combout => \st2~0_combout\);

-- Location: LCCOMB_X17_Y1_N26
\newq0~4\ : cycloneiv_lcell_comb
-- Equation(s):
-- \newq0~4_combout\ = ((\newq0~3_combout\) # (\st2~0_combout\)) # (!\newq0~2_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111111111110101",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \newq0~2_combout\,
	datac => \newq0~3_combout\,
	datad => \st2~0_combout\,
	combout => \newq0~4_combout\);

-- Location: LCCOMB_X25_Y4_N18
\newq1~1\ : cycloneiv_lcell_comb
-- Equation(s):
-- \newq1~1_combout\ = (\newq1~0_combout\) # (!\newq3~0_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1010101011111111",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \newq1~0_combout\,
	datad => \newq3~0_combout\,
	combout => \newq1~1_combout\);

-- Location: LCCOMB_X17_Y1_N22
\newq2~3\ : cycloneiv_lcell_comb
-- Equation(s):
-- \newq2~3_combout\ = ((\st8~0_combout\) # ((\st1~0_combout\) # (\st13~0_combout\))) # (!\newq0~2_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111111111111101",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \newq0~2_combout\,
	datab => \st8~0_combout\,
	datac => \st1~0_combout\,
	datad => \st13~0_combout\,
	combout => \newq2~3_combout\);

-- Location: LCCOMB_X25_Y4_N30
\newq3~2\ : cycloneiv_lcell_comb
-- Equation(s):
-- \newq3~2_combout\ = (\newq3~1_combout\) # (!\newq3~0_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1010101011111111",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \newq3~1_combout\,
	datad => \newq3~0_combout\,
	combout => \newq3~2_combout\);

-- Location: LCCOMB_X25_Y4_N24
\st11~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st11~0_combout\ = (\_~6_combout\ & (!\_~3_combout\ & (!\_~4_combout\ & !\_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000000000010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~6_combout\,
	datab => \_~3_combout\,
	datac => \_~4_combout\,
	datad => \_~5_combout\,
	combout => \st11~0_combout\);

-- Location: LCCOMB_X25_Y9_N0
\st7~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st7~0_combout\ = (!\_~6_combout\ & (\_~4_combout\ & (!\_~3_combout\ & !\_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000000000100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~6_combout\,
	datab => \_~4_combout\,
	datac => \_~3_combout\,
	datad => \_~5_combout\,
	combout => \st7~0_combout\);

-- Location: LCCOMB_X25_Y9_N10
\st6~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st6~0_combout\ = (!\_~6_combout\ & (\_~4_combout\ & (\_~3_combout\ & !\_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000001000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~6_combout\,
	datab => \_~4_combout\,
	datac => \_~3_combout\,
	datad => \_~5_combout\,
	combout => \st6~0_combout\);

-- Location: LCCOMB_X25_Y9_N12
\st4~1\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st4~1_combout\ = (!\_~6_combout\ & (\_~4_combout\ & (\_~3_combout\ & \_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0100000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~6_combout\,
	datab => \_~4_combout\,
	datac => \_~3_combout\,
	datad => \_~5_combout\,
	combout => \st4~1_combout\);

-- Location: LCCOMB_X25_Y9_N14
\st3~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st3~0_combout\ = (\_~6_combout\ & (\_~4_combout\ & (!\_~3_combout\ & !\_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000000001000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~6_combout\,
	datab => \_~4_combout\,
	datac => \_~3_combout\,
	datad => \_~5_combout\,
	combout => \st3~0_combout\);

-- Location: LCCOMB_X25_Y9_N24
\st0~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \st0~0_combout\ = (\_~6_combout\ & (\_~4_combout\ & (\_~3_combout\ & \_~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1000000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \_~6_combout\,
	datab => \_~4_combout\,
	datac => \_~3_combout\,
	datad => \_~5_combout\,
	combout => \st0~0_combout\);

-- Location: LCCOMB_X17_Y1_N14
\r1~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \r1~0_combout\ = (\a~input_o\ & \st9~0_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \a~input_o\,
	datad => \st9~0_combout\,
	combout => \r1~0_combout\);

-- Location: LCCOMB_X25_Y4_N2
\r3~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \r3~0_combout\ = (\st13~0_combout\ & \b~input_o\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \st13~0_combout\,
	datad => \b~input_o\,
	combout => \r3~0_combout\);

ww_newq0 <= \newq0~output_o\;

ww_newq1 <= \newq1~output_o\;

ww_newq2 <= \newq2~output_o\;

ww_newq3 <= \newq3~output_o\;

ww_st15 <= \st15~output_o\;

ww_st14 <= \st14~output_o\;

ww_st13 <= \st13~output_o\;

ww_st12 <= \st12~output_o\;

ww_st11 <= \st11~output_o\;

ww_st10 <= \st10~output_o\;

ww_st9 <= \st9~output_o\;

ww_st8 <= \st8~output_o\;

ww_st7 <= \st7~output_o\;

ww_st6 <= \st6~output_o\;

ww_st5 <= \st5~output_o\;

ww_st4 <= \st4~output_o\;

ww_st3 <= \st3~output_o\;

ww_st2 <= \st2~output_o\;

ww_st1 <= \st1~output_o\;

ww_st0 <= \st0~output_o\;

ww_r0 <= \r0~output_o\;

ww_r1 <= \r1~output_o\;

ww_r2 <= \r2~output_o\;

ww_r3 <= \r3~output_o\;

ww_r4 <= \r4~output_o\;

ww_r5 <= \r5~output_o\;

ww_q(0) <= \q[0]~output_o\;

ww_q(1) <= \q[1]~output_o\;

ww_q(2) <= \q[2]~output_o\;

ww_q(3) <= \q[3]~output_o\;
END structure;


