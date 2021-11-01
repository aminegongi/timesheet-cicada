pipeline {
    agent any
     
    stages {
        stage("Build") {
            steps {
                bat "mvn clean package"
            }
        }
        stage('Deploy to Nexus'){
            steps {
                bat 'mvn deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet-ci -Dversion=1.2 -DgeneratePom=true -Dpackaging=jar  -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-ci-1.2.jar';
            }
        }
        stage('Test Statique SonarQube'){
            steps {
                bat 'mvn sonar:sonar';
            }
        }

    }
    
    post {
        always {
            cleanWs()
        }
        success {
            mail bcc: '', 
            body: ''' Hey,
            The Build of your CiProject Pipeline was successful <3''', cc: '', from: '', replyTo: '', subject: 'Build successfull', to: 'amine.gongi@esprit.tn'
        }
        failure {
            mail bcc: '', 
            body: ''' Hey,
            The Build of your CiProject Pipeline has failed :(''', cc: '', from: '', replyTo: '', subject: 'Build Fail', to: 'amine.gongi@esprit.tn'
        }
    }
}
