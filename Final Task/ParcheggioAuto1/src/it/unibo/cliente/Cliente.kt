/* Generated by AN DISI Unibo */ 
package it.unibo.cliente

import it.unibo.kactor.*
import alice.tuprolog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
	
class Cliente ( name: String, scope: CoroutineScope  ) : ActorBasicFsm( name, scope ){

	override fun getInitialState() : String{
		return "s0"
	}
	@kotlinx.coroutines.ObsoleteCoroutinesApi
	@kotlinx.coroutines.ExperimentalCoroutinesApi			
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		 var TOKENID=-1  
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
					}
					 transition(edgeName="t034",targetState="s1",cond=whenDispatch("slotsnum"))
				}	 
				state("s1") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("slotsnum(SN)"), Term.createTerm("slotsnum(S)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								 var S = payloadArg(0).toInt()  
								if(  S>0  
								 ){request("carenter", "carenter" ,"parkmanagerservice" )  
								}
						}
					}
					 transition(edgeName="t035",targetState="s2",cond=whenReply("receipt"))
				}	 
				state("s2") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("receipt(TOKENID)"), Term.createTerm("receipt(TOKENID)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								 TOKENID = payloadArg(0).toInt()  
								println("Client: TOKEN ricevuto $TOKENID")
						}
						delay(5000) 
						request("acceptout", "acceptout($TOKENID)" ,"parkmanagerservice" )  
					}
					 transition(edgeName="t036",targetState="s3",cond=whenReply("response"))
				}	 
				state("s3") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("response(V)"), Term.createTerm("response(R)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								 var R = payloadArg(0).toBoolean()  
								println("Response: $R")
								if(  !R  
								 ){println("Torno tra poco")
								request("acceptout", "acceptout($TOKENID)" ,"parkmanagerservice" )  
								}
						}
					}
					 transition(edgeName="t037",targetState="s3",cond=whenReply("response"))
					transition(edgeName="t038",targetState="s4",cond=whenEvent("arrivoauto"))
				}	 
				state("s4") { //this:State
					action { //it:State
						delay(20000) 
						emit("autospostata", "autospostata" ) 
						println("Invio evento autospostata")
					}
				}	 
			}
		}
}
