pipeline {
    agent any
     
    stages {
        stage('Okkkkk') {
            steps {
                echo "Okkkkkkkkk"
            }
        }
    }
    
    post {
        always {
            mail bcc: '', 
            body: '''Build successful!!!! $PROJECT_NAME
            Thanks''', cc: '', from: '', replyTo: '', subject: 'Build successfull', to: 'amine.gongi@esprit.tn'
        }
    }
}