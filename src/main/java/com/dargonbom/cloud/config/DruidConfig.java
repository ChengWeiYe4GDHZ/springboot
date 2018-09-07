/**
 * 
 */
package com.dargonbom.cloud.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.dargonbom.cloud.common.DruidSetting;
import com.dargonbom.cloud.common.SpringApplicationContext;

/**
 * @author user
 *
 */
@Configuration
public class DruidConfig {
	@Autowired
	private DruidSetting config;
	
	/**
	 * 注册DruidServlet
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<StatViewServlet> druidServletRegistrationBean() {
		ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>();
		servletRegistrationBean.setServlet(new StatViewServlet());
		servletRegistrationBean.addUrlMappings("/druid/*");
		// 白名单：
		// servletRegistrationBean.addInitParameter("allow","192.168.1.106");
		// IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to
		// view this page.
		// servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
		// 登录查看信息的账号密码.
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		servletRegistrationBean.addInitParameter("loginPassword", "123456");
		// 是否能够重置数据.
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		return servletRegistrationBean;
	}

	/**
	 * 注册DruidFilter拦截
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<WebStatFilter> duridFilterRegistrationBean() {
		FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
		filterRegistrationBean.setFilter(new WebStatFilter());
		Map<String, String> initParams = new HashMap<String, String>();
		// 设置忽略请求
		initParams.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
		filterRegistrationBean.setInitParameters(initParams);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}

	/**
	 * 配置DruidDataSource
	 * 
	 * @return
	 * @throws SQLException
	 */
	@Bean
	@Primary // 在同样的DataSource中，首先使用被标注的DataSource
	public DruidDataSource druidDataSource() throws SQLException {
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(config.getDbUrl());
		datasource.setUsername(config.getUsername());
		datasource.setPassword(config.getPassword());
		datasource.setDriverClassName(config.getDriverClassName());

		// configuration
		datasource.setInitialSize(config.getInitialSize());
		datasource.setMinIdle(config.getMinIdle());
		datasource.setMaxActive(config.getMaxActive());
		datasource.setMaxWait(config.getMaxWait());
		datasource.setTimeBetweenEvictionRunsMillis(config.getTimeBetweenEvictionRunsMillis());
		datasource.setMinEvictableIdleTimeMillis(config.getMinEvictableIdleTimeMillis());
		datasource.setValidationQuery(config.getValidationQuery());
		datasource.setTestWhileIdle(config.isTestWhileIdle());
		datasource.setTestOnBorrow(config.isTestOnBorrow());
		datasource.setTestOnReturn(config.isTestOnReturn());
		datasource.setPoolPreparedStatements(config.isPoolPreparedStatements());
		datasource.setMaxPoolPreparedStatementPerConnectionSize(config.getMaxPoolPreparedStatementPerConnectionSize());
		datasource.setUseGlobalDataSourceStat(config.isUseGlobalDataSourceStat());
		try {
			datasource.setFilters(config.getFilters());
		} catch (SQLException e) {
			System.err.println("druid configuration initialization filter: " + e);
		}
		datasource.setConnectionProperties(config.getConnectionProperties());
		return datasource;
	}

	// 配置transactionManager
	@Bean
	public PlatformTransactionManager transactionManager() throws SQLException {
		DruidDataSource dataSource = SpringApplicationContext.getBean(DruidDataSource.class);
		return new DataSourceTransactionManager(dataSource);
	}
	
}
