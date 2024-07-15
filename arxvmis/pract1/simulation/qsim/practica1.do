onerror {exit -code 1}
vlib work
vlog -work work practica1.vo
vlog -work work Waveform.vwf.vt
vsim -novopt -c -t 1ps -L cyclonev_ver -L altera_ver -L altera_mf_ver -L 220model_ver -L sgate work.practica1_vlg_vec_tst -voptargs="+acc"
vcd file -direction practica1.msim.vcd
vcd add -internal practica1_vlg_vec_tst/*
vcd add -internal practica1_vlg_vec_tst/i1/*
run -all
quit -f
