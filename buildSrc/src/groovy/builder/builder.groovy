package builder

import org.gradle.api.Plugin
import org.gradle.api.Project

class Architecture implements Plugin<Project> {
    void apply(Project project) {

        project.extensions.create("dateAndTime", DateAndTimePluginExtension)
        project.task('showTime') << {
            println "Current time is " + new Date().format(project.dateAndTime.timeFormat)
        }
        project.tasks.create('showDate') << {
            println "Current date is " + new Date().format(project.dateAndTime.dateFormat)
        }
    }
}

class DateAndTimePluginExtension {
    String timeFormat = "MM/dd/yyyyHH:mm:ss.SSS"
    String dateFormat = "yyyy-MM-dd"
}