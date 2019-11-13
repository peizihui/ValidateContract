package io.hpb.service;

import com.github.pagehelper.PageInfo;


import java.util.List;
import java.util.Map;

public interface ContractEventService {

    //PageInfo<EventInfo> queryPageEventInfoByTxHash(String txHash, int pageNum, int pageSize);

    Map<String, List<Object>> queryEventLogAndStateDiff(String txHash);


}
