package org.scoverage

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.scala.ScalaCompile

class ScoveragePlugin implements Plugin<Project> {
    static String CONFIGURATION_NAME = 'scoverage'

    static String TEST_NAME = 'testScoverage'
    static String REPORT_NAME = 'reportScoverage'
    static String CHECK_NAME = 'checkScoverage'
    static String COMPILE_NAME = 'compileScoverageScala'
    static String COMPILE_TEST_NAME = 'compileTestScoverageScala'

    @Override
    void apply(Project t) {
        if (t.extensions.findByName(CONFIGURATION_NAME) == null) {
            t.extensions.create(CONFIGURATION_NAME, ScoverageExtension, t)
        }
    }

    protected static ScoverageExtension extensionIn(Project project) {
        project.extensions[CONFIGURATION_NAME]
    }

    protected static String encoding(Project project) {
        ScalaCompile compile = project.tasks[ScoveragePlugin.COMPILE_NAME] as ScalaCompile
        compile.scalaCompileOptions.encoding
    }
}
