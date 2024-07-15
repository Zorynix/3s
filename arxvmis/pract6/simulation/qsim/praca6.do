onerror {exit -code 1}
vlib work
vlog -work work praca6.vo
vlog -work work a1b1.vwf.vt
vsim -novopt -c -t 1ps -L maxii_ver -L altera_ver -L altera_mf_ver -L 220model_ver -L sgate work.praca6_vlg_vec_tst -voptargs="+acc"
vcd file -direction praca6.msim.vcd
vcd add -internal praca6_vlg_vec_tst/*
vcd add -internal praca6_vlg_vec_tst/i1/*
run -all
quit -f
