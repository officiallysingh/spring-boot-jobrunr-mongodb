//package com.ksoot.jobrunr.conf;
//
//import com.mongodb.client.MongoClient;
//import org.jobrunr.jobs.mappers.JobMapper;
//import org.jobrunr.spring.autoconfigure.JobRunrAutoConfiguration;
//import org.jobrunr.spring.autoconfigure.JobRunrProperties;
//import org.jobrunr.storage.StorageProvider;
//import org.jobrunr.storage.StorageProviderUtils;
//import org.jobrunr.storage.nosql.mongo.MongoDBStorageProvider;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@AutoConfigureBefore(JobRunrAutoConfiguration.class)
//@AutoConfigureAfter(MongoDBConfig.class)
//@ConditionalOnProperty(
//    prefix = "org.jobrunr.database",
//    name = "type",
//    havingValue = "mongodb",
//    matchIfMissing = true)
//public class JobRunrConfig {
//
//  @Bean(name = "storageProvider", destroyMethod = "close")
//  @ConditionalOnMissingBean
//  public StorageProvider mongoDBStorageProvider(
//      MongoClient mongoClient, JobMapper jobMapper, JobRunrProperties properties) {
//    String databaseName = properties.getDatabase().getDatabaseName();
//    String tablePrefix = properties.getDatabase().getTablePrefix();
//    StorageProviderUtils.DatabaseOptions databaseOptions =
//        properties.getDatabase().isSkipCreate()
//            ? StorageProviderUtils.DatabaseOptions.SKIP_CREATE
//            : StorageProviderUtils.DatabaseOptions.CREATE;
//    MongoDBStorageProvider mongoDBStorageProvider =
//        new MongoDBStorageProvider(mongoClient, databaseName, tablePrefix, databaseOptions);
//    mongoDBStorageProvider.setJobMapper(jobMapper);
//    return mongoDBStorageProvider;
//  }
//}
