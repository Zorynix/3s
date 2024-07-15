onerror {exit -code 1}
vlib work
vlog -work work pract7.vo
vlog -work work a1b1.vwf.vt
vsim -novopt -c -t 1ps -L cycloneiv_ver -L altera_ver -L altera_mf_ver -L 220model_ver -L sgate work.pract7_vlg_vec_tst -voptargs="+acc"
vcd file -direction pract7.msim.vcd
vcd add -internal pract7_vlg_vec_tst/*
vcd add -internal pract7_vlg_vec_tst/i1/*
run -all
quit -f
