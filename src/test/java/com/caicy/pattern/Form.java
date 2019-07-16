//private HostAndPort initSentinels(Set<String> sentinels,final String masterName){
//        HostAndPort master=null;
//        boolean sentinelAvailable=false;
//        log.info("Trying to find master from available Sentinels...");
//        // 有多个sentinels,遍历这些个sentinels
//        for(String sentinel:sentinels){
//                // host:port表示的sentinel地址转化为一个HostAndPort对象。
//                final HostAndPort hap=HostAndPort.parseString(sentinel);
//                log.fine("Connecting to Sentinel "+hap);
//                Jedis jedis=null;
//                try{
//                // 连接到sentinel
//                        jedis=new Jedis(hap.getHost(),hap.getPort());
//                // 根据masterName得到master的地址，返回一个list，host= list[0], port =// list[1]
//                        List<String> masterAddr=jedis.sentinelGetMasterAddrByName(masterName);
//                // connected to sentinel...
//                        sentinelAvailable=true;
//                        if(masterAddr==null||masterAddr.size()!=2){
//                        log.warning("Can not get master addr, master name: "+masterName+".
//                        Sentinel:" + hap
//                        +".");
//                        continue;
//                        }
//                // 如果在任何一个sentinel中找到了master，不再遍历sentinels
//                        master=toHostAndPort(masterAddr);
//                        log.fine("Found Redis master at "+master);
//                        break;
//                }catch(JedisException e){
//                    // resolves #1036, it should handle JedisException there's another chance
//                    // of raising JedisDataException
//                    log.warning("Cannot get master address from sentinel running @ "+hap+".
//                    Reason:" + e
//                    +". Trying next one.");
//                }finally{
//                    if(jedis!=null){
//                        jedis.close();
//                    }
//                }
//        }
//        // 到这里，如果master为null，则说明有两种情况，一种是所有的sentinels节点都down掉了，一种是master节点没有被存活的sentinels监控到
//        if(master==null){
//            if(sentinelAvailable){
//        // can connect to sentinel, but master name seems to not
//        // monitored
//                throw new JedisException("Can connect to sentinel, but "+masterName
//                +" seems to be not monitored...");
//            }else{
//                throw new JedisConnectionException("All sentinels down, cannot determine where is
//                "
//                +masterName+" master is running...");
//            }
//        }
//        //如果走到这里，说明找到了master的地址
//        log.info("Redis master running at "+master+", starting Sentinel listeners...");
//        //启动对每个sentinels的监听为每个sentinel都启动了一个监听者MasterListener。MasterListener本身是一个线程，它会去订阅sentinel上关于master节点地址改变的消息。
//        for(String sentinel:sentinels){
//            final HostAndPort hap=HostAndPort.parseString(sentinel);
//            MasterListener masterListener=new MasterListener(masterName,hap.getHost(),
//            hap.getPort());
//            // whether MasterListener threads are alive or not, process can be stopped
//            masterListener.setDaemon(true);
//            masterListeners.add(masterListener);
//            masterListener.start();
//        }
//        return master;
//}