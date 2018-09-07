/**
 * 
 */
package com.dargonbom.cloud.common;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author user
 *
 */
@Component
@ConfigurationProperties(prefix="spring")
public class DruidSetting implements Serializable {

	private static final long serialVersionUID = 1L;
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.initialSize}")
	private int initialSize;
	@Value("${spring.datasource.minIdle}")
	private int minIdle;
	@Value("${spring.datasource.maxActive}")
	private int maxActive;
	@Value("${spring.datasource.maxWait}")
	private int maxWait;
	@Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;
	@Value("${spring.datasource.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
	@Value("${spring.datasource.validationQuery}")
	private String validationQuery;
	@Value("${spring.datasource.testWhileIdle}")
	private boolean testWhileIdle;
	@Value("${spring.datasource.testOnBorrow}")
	private boolean testOnBorrow;
	@Value("${spring.datasource.testOnReturn}")
	private boolean testOnReturn;
	@Value("${spring.datasource.poolPreparedStatements}")
	private boolean poolPreparedStatements;
	@Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;
	@Value("${spring.datasource.filters}")
	private String filters;
	@Value("${spring.datasource.connectionProperties}")
	private String connectionProperties;
	@Value("${spring.datasource.useGlobalDataSourceStat}")
	private boolean useGlobalDataSourceStat;
	/**
	 * @return the dbUrl
	 */
	public String getDbUrl() {
		return dbUrl;
	}
	/**
	 * @param dbUrl the dbUrl to set
	 */
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the driverClassName
	 */
	public String getDriverClassName() {
		return driverClassName;
	}
	/**
	 * @param driverClassName the driverClassName to set
	 */
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	/**
	 * @return the initialSize
	 */
	public int getInitialSize() {
		return initialSize;
	}
	/**
	 * @param initialSize the initialSize to set
	 */
	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}
	/**
	 * @return the minIdle
	 */
	public int getMinIdle() {
		return minIdle;
	}
	/**
	 * @param minIdle the minIdle to set
	 */
	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	/**
	 * @return the maxActive
	 */
	public int getMaxActive() {
		return maxActive;
	}
	/**
	 * @param maxActive the maxActive to set
	 */
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	/**
	 * @return the maxWait
	 */
	public int getMaxWait() {
		return maxWait;
	}
	/**
	 * @param maxWait the maxWait to set
	 */
	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}
	/**
	 * @return the timeBetweenEvictionRunsMillis
	 */
	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}
	/**
	 * @param timeBetweenEvictionRunsMillis the timeBetweenEvictionRunsMillis to set
	 */
	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}
	/**
	 * @return the minEvictableIdleTimeMillis
	 */
	public int getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}
	/**
	 * @param minEvictableIdleTimeMillis the minEvictableIdleTimeMillis to set
	 */
	public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}
	/**
	 * @return the validationQuery
	 */
	public String getValidationQuery() {
		return validationQuery;
	}
	/**
	 * @param validationQuery the validationQuery to set
	 */
	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
	/**
	 * @return the testWhileIdle
	 */
	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}
	/**
	 * @param testWhileIdle the testWhileIdle to set
	 */
	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}
	/**
	 * @return the testOnBorrow
	 */
	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}
	/**
	 * @param testOnBorrow the testOnBorrow to set
	 */
	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	/**
	 * @return the testOnReturn
	 */
	public boolean isTestOnReturn() {
		return testOnReturn;
	}
	/**
	 * @param testOnReturn the testOnReturn to set
	 */
	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	/**
	 * @return the poolPreparedStatements
	 */
	public boolean isPoolPreparedStatements() {
		return poolPreparedStatements;
	}
	/**
	 * @param poolPreparedStatements the poolPreparedStatements to set
	 */
	public void setPoolPreparedStatements(boolean poolPreparedStatements) {
		this.poolPreparedStatements = poolPreparedStatements;
	}
	/**
	 * @return the maxPoolPreparedStatementPerConnectionSize
	 */
	public int getMaxPoolPreparedStatementPerConnectionSize() {
		return maxPoolPreparedStatementPerConnectionSize;
	}
	/**
	 * @param maxPoolPreparedStatementPerConnectionSize the maxPoolPreparedStatementPerConnectionSize to set
	 */
	public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
		this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
	}
	/**
	 * @return the filters
	 */
	public String getFilters() {
		return filters;
	}
	/**
	 * @param filters the filters to set
	 */
	public void setFilters(String filters) {
		this.filters = filters;
	}
	/**
	 * @return the connectionProperties
	 */
	public String getConnectionProperties() {
		return connectionProperties;
	}
	/**
	 * @param connectionProperties the connectionProperties to set
	 */
	public void setConnectionProperties(String connectionProperties) {
		this.connectionProperties = connectionProperties;
	}
	/**
	 * @return the useGlobalDataSourceStat
	 */
	public boolean isUseGlobalDataSourceStat() {
		return useGlobalDataSourceStat;
	}
	/**
	 * @param useGlobalDataSourceStat the useGlobalDataSourceStat to set
	 */
	public void setUseGlobalDataSourceStat(boolean useGlobalDataSourceStat) {
		this.useGlobalDataSourceStat = useGlobalDataSourceStat;
	}
	
	
}
