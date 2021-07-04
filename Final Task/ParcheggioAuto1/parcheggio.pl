%====================================================================================
% parcheggio description   
%====================================================================================
context(ctxparcheggio, "localhost",  "TCP", "8082").
 qactor( door, ctxparcheggio, "it.unibo.door.Door").
  qactor( cliente, ctxparcheggio, "it.unibo.cliente.Cliente").
