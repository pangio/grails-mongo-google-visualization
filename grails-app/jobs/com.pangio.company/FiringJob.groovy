package com.pangio.company

import org.apache.commons.logging.LogFactory

import com.gmongo.GMongo

class FiringJob {

    private static final log = LogFactory.getLog(this)

    def group = "firingGroup"
    def description = "Firing job with Cron Trigger"

    def mongo = new GMongo()
    def db = mongo.getDB("company")
    def employeesColletion =  db.employee
    def employee

    static triggers = {
        cron name: 'firingTrigger', cronExpression: "0/5 * * * * ?"
    }

    def execute(){
        try {
            employee = employeesColletion.findOne()
            employeesColletion.remove(employee)
            log.info(employee.firstName + ' has been fired')
        } catch (NullPointerException e) {
            log.info('Employee not found. Nobody has been fired!')
        }
    }
}
