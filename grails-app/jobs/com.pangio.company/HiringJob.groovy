package com.pangio.company

import com.gmongo.GMongo
import com.mongodb.DBObject
import org.apache.commons.logging.LogFactory

class HiringJob {

    private static final log = LogFactory.getLog(this)

    def employee

    def group = "hiringGroup"
    def description = "Hiring job with Cron Trigger"

    static triggers = {
        cron name: 'hiringTrigger', cronExpression: "0/2 * * * * ?"
    }

    def execute(){
        Random random = new Random();
        int randomSalary = random.nextInt((50000 - 15000) + 1) + 15000;
        employee = new Employee(firstName: FirstName.getRandom(), lastName: 'Somebody', salary: randomSalary.longValue(), gender: Gender.getRandom(), country: Country.getRandom()).save(flush: true)
        log.info(employee.lastName + ' has been hired in ' + employee.country)
    }
}
