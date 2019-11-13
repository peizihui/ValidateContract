package io.hpb.service;

import com.github.pagehelper.PageInfo;
import io.hpb.entity.ContractErcStandardInfo;

import java.util.List;

public interface ContractErcStandardInfoService {

    public void saveContractErcStandardInfo(ContractErcStandardInfo recored);

    public List<ContractErcStandardInfo> getContractErcStandardInfoList(ContractErcStandardInfo recored);

    public PageInfo<ContractErcStandardInfo> queryPageContractErcStandardInfo(ContractErcStandardInfo contractErcStandardInfo, int pageNum, int pageSize);

    ContractErcStandardInfo getContractErcStandardInfoByContractAddress(String contractAddress);

    ContractErcStandardInfo selectByContractAddress(String contractAddress);

}
