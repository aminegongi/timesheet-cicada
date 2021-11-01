pipeline {
    agent any

    stages {
        stage("Build") {
            steps {
                bat "mvn clean package"
            }
        }
        stage('Nexus deploy'){
            steps {
                bat 'mvn deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet-ci -Dversion=1.3 -DgeneratePom=true -Dpackaging=jar  -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-ci-1.3.jar';
            }
        }
        stage('Sonar Test'){
            steps {
                bat 'mvn sonar:sonar';
            }
        }
    }
    
    post {
        always {
            cleanWs()
            mail bcc: '', 
            body: '''Build Done , please check result !''', cc: '', from: '', replyTo: '', subject: 'Jenkins Build', to: 'nour.dziri1@esprit.tn'
        }
    }
}