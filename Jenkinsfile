pipeline
{
    agent any
    tools
    {
        maven 'MAVEN_HOME'
    }
    stages
    {
        stage('checkout')
        {
            steps
            {
                checkout scm
            }
        }
        stage('build')
        {
            steps
            {
                bat "mvn clean install"
            }
        }
    }
}
