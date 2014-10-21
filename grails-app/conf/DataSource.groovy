dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
	  username = "sa"
	  password = ""
}

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}

// environment specific settings
environments {
    
    development {
        dataSource {
            dbCreate = "validate" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    
    test {
        dataSource {
            dbCreate = "validate"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    
    production {
        dataSource {

            dbCreate = "validate"
            driverClassName = "org.postgresql.Driver"
            dialect = org.hibernate.dialect.PostgreSQLDialect

            uri = new URI(System.env.DATABASE_URL?:"postgres://dohfhduvmubcqn:BGmqyIja8bqT7Nsd5yzwUg5ZeC@ec2-54-83-204-85.compute-1.amazonaws.com:5432/d3h2r5och27n95")

            url = "jdbc:postgresql://"+uri.host+uri.path
            username = uri.userInfo.split(":")[0]
            password = uri.userInfo.split(":")[1]


            /*dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }*/
        }
    }
}
