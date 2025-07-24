pipeline{
    agent any 
   stages{ 
    stage('clone code') {
        steps{ 
            git branch: 'main', url: 'https://github.com/Prajakta18-boop/calyx.git'
            }
            
    }
    stage('deploying code') {
        steps{
            sh 'sudo mv /var/lib/jenkins/workspace/agentB/index.html /var/www/html/CALYX/'
        }
    }   
    stage ('restarting nginx'){
        steps{
           sh 'sudo systemctl restart nginx'
        }
    }
   }

}