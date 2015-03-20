grails {
    mongo {
        host            = "localhost"
        port            = 27017
        options {
            autoConnectRetry    = true
            connectTimeout      = 300
        }
    }
}
environments {
    development {
        grails {
            mongo {
                createDrop      = "database"
                databaseName    = "company"
            }
        }
    }
}
