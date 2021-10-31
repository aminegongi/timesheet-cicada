pipeline {
    agent any
     
    stages {
        stage("Build") {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Deploy to Nexus'){
            steps {
                bat 'mvn deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet-ci -Dversion=1.1 -DgeneratePom=true -Dpackaging=jar  -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-ci-1.1.jar';
            }
        }
        stage('Test Statique Sonar'){
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
