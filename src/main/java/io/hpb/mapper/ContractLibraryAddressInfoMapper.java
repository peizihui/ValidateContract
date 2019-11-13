package io.hpb.mapper;

import io.hpb.entity.ContractLibraryAddressInfo;
import io.hpb.example.ContractLibraryAddressInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContractLibraryAddressInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_library_address_info
     *
     * @mbg.generated
     */
    long countByExample(ContractLibraryAddressInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_library_address_info
     *
     * @mbg.generated
     */
    int deleteByExample(ContractLibraryAddressInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_library_address_info
     *
     * @mbg.generated
     */
    int insert(ContractLibraryAddressInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_library_address_info
     *
     * @mbg.generated
     */
    int insertSelective(ContractLibraryAddressInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_library_address_info
     *
     * @mbg.generated
     */
    List<ContractLibraryAddressInfo> selectByExample(ContractLibraryAddressInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_library_address_info
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ContractLibraryAddressInfo record, @Param("example") ContractLibraryAddressInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_library_address_info
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ContractLibraryAddressInfo record, @Param("example") ContractLibraryAddressInfoExample example);
}