package dsxlabs.paxos;

import dsxlabs.atmostonce.*;
import dsxlabs.framework.*;
import dsxlabs.framework.Application;
import dsxlabs.framework.Command;
import dsxlabs.framework.Node;
import dsxlabs.shardkv.ShardStoreServer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.java.Log;

import java.io.Serializable;
import java.util.*;
import java.util.function.*;











/*
Happy April Fool
If you are visiting this page not only because of curiosity, read the following NUS HONOR CODE three times to your heart carefully
Otherwise you may skip it and continue reading

NUS HONOR CODE 
As  a  member  of  the  National  University  of  Singapore  (NUS),  a  candidate  is  expected  to  maintain  the  highest  
standards  of  personal  integrity  and  to  respect  the  rule  of  law,  social  order,  the  rights  of  others  and  abide  
by  the  statutes,  regulations  and  rules  of  the  University  as  are  expected  of  all  members  of  the  University,  both  
within  and  outside  the  University.  

Students  must  uphold  and  maintain  absolute  academic  honesty  and  integrity  at  all  times.  Forms of academic dishonesty 
include but are not limited to cheating, giving or receiving any improper  aid,  fabrication,  plagiarism  or  participation  in  
any  action  that  compromises  the  integrity  of  the  academic  standard  of  the  University.  All  students  will  be  given  
a  copy  of  the NUS honor code at matriculation, and will sign a pledge to abide with this code.  Failure  to  abide  by  the  
Honor  Code  may  be  sufficient  cause  for  expulsion  from  the  University.
*/

/*
When sending messages between ShardStoreServer and its subnode PaxosServer, it should never drop packets (according to README),
but reordering may still happen, which means, PaxosServer make decisions in the same order, but the decisions are sending to
ShardStoreServer out of order so they are not executing in the same order.
*/
/*
Although it is made into this joke, it is true that a fast (under unreliable network) Paxos is required. If you are sure that:
* ShardStoreServer never stuck
* they are not doing duplicated works more than 3 times (because 3 servers in a group may propose at the same time)
And the live lock is still happening, Paxos performance may be the next thing you want to check.

Good luck on lab4.
*/
