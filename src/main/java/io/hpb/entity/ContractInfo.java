package io.hpb.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ContractInfo extends BaseEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.contract_addr
     *
     * @mbg.generated
     */
    private String contractAddr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.contract_creater
     *
     * @mbg.generated
     */
    private String contractCreater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.contract_name
     *
     * @mbg.generated
     */
    private String contractName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.contract_type
     *
     * @mbg.generated
     */
    private String contractType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.optimize_flag
     *
     * @mbg.generated
     */
    private String optimizeFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.balance
     *
     * @mbg.generated
     */
    private BigDecimal balance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.tx_count
     *
     * @mbg.generated
     */
    private Long txCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.verified_status
     *
     * @mbg.generated
     */
    private String verifiedStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.dapp_url
     *
     * @mbg.generated
     */
    private String dappUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.misc_setting_runs
     *
     * @mbg.generated
     */
    private Long miscSettingRuns;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.hvm_version
     *
     * @mbg.generated
     */
    private String hvmVersion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.compiler_type
     *
     * @mbg.generated
     */
    private String compilerType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.compiler_version
     *
     * @mbg.generated
     */
    private String compilerVersion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.create_timestamp
     *
     * @mbg.generated
     */
    private Date createTimestamp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.verified_timestamp
     *
     * @mbg.generated
     */
    private Date verifiedTimestamp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.contract_src
     *
     * @mbg.generated
     */
    private String contractSrc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.contract_abi
     *
     * @mbg.generated
     */
    private String contractAbi;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_info.contract_bin
     *
     * @mbg.generated
     */
    private String contractBin;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.contract_addr
     *
     * @return the value of contract_info.contract_addr
     *
     * @mbg.generated
     */
    public String getContractAddr() {
        return contractAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.contract_addr
     *
     * @param contractAddr the value for contract_info.contract_addr
     *
     * @mbg.generated
     */
    public void setContractAddr(String contractAddr) {
        this.contractAddr = contractAddr == null ? null : contractAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.contract_creater
     *
     * @return the value of contract_info.contract_creater
     *
     * @mbg.generated
     */
    public String getContractCreater() {
        return contractCreater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.contract_creater
     *
     * @param contractCreater the value for contract_info.contract_creater
     *
     * @mbg.generated
     */
    public void setContractCreater(String contractCreater) {
        this.contractCreater = contractCreater == null ? null : contractCreater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.contract_name
     *
     * @return the value of contract_info.contract_name
     *
     * @mbg.generated
     */
    public String getContractName() {
        return contractName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.contract_name
     *
     * @param contractName the value for contract_info.contract_name
     *
     * @mbg.generated
     */
    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.contract_type
     *
     * @return the value of contract_info.contract_type
     *
     * @mbg.generated
     */
    public String getContractType() {
        return contractType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.contract_type
     *
     * @param contractType the value for contract_info.contract_type
     *
     * @mbg.generated
     */
    public void setContractType(String contractType) {
        this.contractType = contractType == null ? null : contractType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.optimize_flag
     *
     * @return the value of contract_info.optimize_flag
     *
     * @mbg.generated
     */
    public String getOptimizeFlag() {
        return optimizeFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.optimize_flag
     *
     * @param optimizeFlag the value for contract_info.optimize_flag
     *
     * @mbg.generated
     */
    public void setOptimizeFlag(String optimizeFlag) {
        this.optimizeFlag = optimizeFlag == null ? null : optimizeFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.balance
     *
     * @return the value of contract_info.balance
     *
     * @mbg.generated
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.balance
     *
     * @param balance the value for contract_info.balance
     *
     * @mbg.generated
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.tx_count
     *
     * @return the value of contract_info.tx_count
     *
     * @mbg.generated
     */
    public Long getTxCount() {
        return txCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.tx_count
     *
     * @param txCount the value for contract_info.tx_count
     *
     * @mbg.generated
     */
    public void setTxCount(Long txCount) {
        this.txCount = txCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.verified_status
     *
     * @return the value of contract_info.verified_status
     *
     * @mbg.generated
     */
    public String getVerifiedStatus() {
        return verifiedStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.verified_status
     *
     * @param verifiedStatus the value for contract_info.verified_status
     *
     * @mbg.generated
     */
    public void setVerifiedStatus(String verifiedStatus) {
        this.verifiedStatus = verifiedStatus == null ? null : verifiedStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.dapp_url
     *
     * @return the value of contract_info.dapp_url
     *
     * @mbg.generated
     */
    public String getDappUrl() {
        return dappUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.dapp_url
     *
     * @param dappUrl the value for contract_info.dapp_url
     *
     * @mbg.generated
     */
    public void setDappUrl(String dappUrl) {
        this.dappUrl = dappUrl == null ? null : dappUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.misc_setting_runs
     *
     * @return the value of contract_info.misc_setting_runs
     *
     * @mbg.generated
     */
    public Long getMiscSettingRuns() {
        return miscSettingRuns;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.misc_setting_runs
     *
     * @param miscSettingRuns the value for contract_info.misc_setting_runs
     *
     * @mbg.generated
     */
    public void setMiscSettingRuns(Long miscSettingRuns) {
        this.miscSettingRuns = miscSettingRuns;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.hvm_version
     *
     * @return the value of contract_info.hvm_version
     *
     * @mbg.generated
     */
    public String getHvmVersion() {
        return hvmVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.hvm_version
     *
     * @param hvmVersion the value for contract_info.hvm_version
     *
     * @mbg.generated
     */
    public void setHvmVersion(String hvmVersion) {
        this.hvmVersion = hvmVersion == null ? null : hvmVersion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.compiler_type
     *
     * @return the value of contract_info.compiler_type
     *
     * @mbg.generated
     */
    public String getCompilerType() {
        return compilerType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.compiler_type
     *
     * @param compilerType the value for contract_info.compiler_type
     *
     * @mbg.generated
     */
    public void setCompilerType(String compilerType) {
        this.compilerType = compilerType == null ? null : compilerType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.compiler_version
     *
     * @return the value of contract_info.compiler_version
     *
     * @mbg.generated
     */
    public String getCompilerVersion() {
        return compilerVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.compiler_version
     *
     * @param compilerVersion the value for contract_info.compiler_version
     *
     * @mbg.generated
     */
    public void setCompilerVersion(String compilerVersion) {
        this.compilerVersion = compilerVersion == null ? null : compilerVersion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.create_timestamp
     *
     * @return the value of contract_info.create_timestamp
     *
     * @mbg.generated
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.create_timestamp
     *
     * @param createTimestamp the value for contract_info.create_timestamp
     *
     * @mbg.generated
     */
    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.verified_timestamp
     *
     * @return the value of contract_info.verified_timestamp
     *
     * @mbg.generated
     */
    public Date getVerifiedTimestamp() {
        return verifiedTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.verified_timestamp
     *
     * @param verifiedTimestamp the value for contract_info.verified_timestamp
     *
     * @mbg.generated
     */
    public void setVerifiedTimestamp(Date verifiedTimestamp) {
        this.verifiedTimestamp = verifiedTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.contract_src
     *
     * @return the value of contract_info.contract_src
     *
     * @mbg.generated
     */
    public String getContractSrc() {
        return contractSrc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.contract_src
     *
     * @param contractSrc the value for contract_info.contract_src
     *
     * @mbg.generated
     */
    public void setContractSrc(String contractSrc) {
        this.contractSrc = contractSrc == null ? null : contractSrc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.contract_abi
     *
     * @return the value of contract_info.contract_abi
     *
     * @mbg.generated
     */
    public String getContractAbi() {
        return contractAbi;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.contract_abi
     *
     * @param contractAbi the value for contract_info.contract_abi
     *
     * @mbg.generated
     */
    public void setContractAbi(String contractAbi) {
        this.contractAbi = contractAbi == null ? null : contractAbi.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_info.contract_bin
     *
     * @return the value of contract_info.contract_bin
     *
     * @mbg.generated
     */
    public String getContractBin() {
        return contractBin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_info.contract_bin
     *
     * @param contractBin the value for contract_info.contract_bin
     *
     * @mbg.generated
     */
    public void setContractBin(String contractBin) {
        this.contractBin = contractBin == null ? null : contractBin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_info
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ContractInfo other = (ContractInfo) that;
        return (this.getContractAddr() == null ? other.getContractAddr() == null : this.getContractAddr().equals(other.getContractAddr()))
            && (this.getContractCreater() == null ? other.getContractCreater() == null : this.getContractCreater().equals(other.getContractCreater()))
            && (this.getContractName() == null ? other.getContractName() == null : this.getContractName().equals(other.getContractName()))
            && (this.getContractType() == null ? other.getContractType() == null : this.getContractType().equals(other.getContractType()))
            && (this.getOptimizeFlag() == null ? other.getOptimizeFlag() == null : this.getOptimizeFlag().equals(other.getOptimizeFlag()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getTxCount() == null ? other.getTxCount() == null : this.getTxCount().equals(other.getTxCount()))
            && (this.getVerifiedStatus() == null ? other.getVerifiedStatus() == null : this.getVerifiedStatus().equals(other.getVerifiedStatus()))
            && (this.getDappUrl() == null ? other.getDappUrl() == null : this.getDappUrl().equals(other.getDappUrl()))
            && (this.getMiscSettingRuns() == null ? other.getMiscSettingRuns() == null : this.getMiscSettingRuns().equals(other.getMiscSettingRuns()))
            && (this.getHvmVersion() == null ? other.getHvmVersion() == null : this.getHvmVersion().equals(other.getHvmVersion()))
            && (this.getCompilerType() == null ? other.getCompilerType() == null : this.getCompilerType().equals(other.getCompilerType()))
            && (this.getCompilerVersion() == null ? other.getCompilerVersion() == null : this.getCompilerVersion().equals(other.getCompilerVersion()))
            && (this.getCreateTimestamp() == null ? other.getCreateTimestamp() == null : this.getCreateTimestamp().equals(other.getCreateTimestamp()))
            && (this.getVerifiedTimestamp() == null ? other.getVerifiedTimestamp() == null : this.getVerifiedTimestamp().equals(other.getVerifiedTimestamp()))
            && (this.getContractSrc() == null ? other.getContractSrc() == null : this.getContractSrc().equals(other.getContractSrc()))
            && (this.getContractAbi() == null ? other.getContractAbi() == null : this.getContractAbi().equals(other.getContractAbi()))
            && (this.getContractBin() == null ? other.getContractBin() == null : this.getContractBin().equals(other.getContractBin()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_info
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getContractAddr() == null) ? 0 : getContractAddr().hashCode());
        result = prime * result + ((getContractCreater() == null) ? 0 : getContractCreater().hashCode());
        result = prime * result + ((getContractName() == null) ? 0 : getContractName().hashCode());
        result = prime * result + ((getContractType() == null) ? 0 : getContractType().hashCode());
        result = prime * result + ((getOptimizeFlag() == null) ? 0 : getOptimizeFlag().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getTxCount() == null) ? 0 : getTxCount().hashCode());
        result = prime * result + ((getVerifiedStatus() == null) ? 0 : getVerifiedStatus().hashCode());
        result = prime * result + ((getDappUrl() == null) ? 0 : getDappUrl().hashCode());
        result = prime * result + ((getMiscSettingRuns() == null) ? 0 : getMiscSettingRuns().hashCode());
        result = prime * result + ((getHvmVersion() == null) ? 0 : getHvmVersion().hashCode());
        result = prime * result + ((getCompilerType() == null) ? 0 : getCompilerType().hashCode());
        result = prime * result + ((getCompilerVersion() == null) ? 0 : getCompilerVersion().hashCode());
        result = prime * result + ((getCreateTimestamp() == null) ? 0 : getCreateTimestamp().hashCode());
        result = prime * result + ((getVerifiedTimestamp() == null) ? 0 : getVerifiedTimestamp().hashCode());
        result = prime * result + ((getContractSrc() == null) ? 0 : getContractSrc().hashCode());
        result = prime * result + ((getContractAbi() == null) ? 0 : getContractAbi().hashCode());
        result = prime * result + ((getContractBin() == null) ? 0 : getContractBin().hashCode());
        return result;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table contract_info
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        contractAddr("contract_addr"),
        contractCreater("contract_creater"),
        contractName("contract_name"),
        contractType("contract_type"),
        optimizeFlag("optimize_flag"),
        balance("balance"),
        txCount("tx_count"),
        verifiedStatus("verified_status"),
        dappUrl("dapp_url"),
        miscSettingRuns("misc_setting_runs"),
        hvmVersion("hvm_version"),
        compilerType("compiler_type"),
        compilerVersion("compiler_version"),
        createTimestamp("create_timestamp"),
        verifiedTimestamp("verified_timestamp"),
        contractSrc("contract_src"),
        contractAbi("contract_abi"),
        contractBin("contract_bin");

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table contract_info
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table contract_info
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table contract_info
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table contract_info
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column) {
            this.column = column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table contract_info
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.column + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table contract_info
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.column + " ASC";
        }
    }
}