pipeline {
  agent {
    kubernetes {
      label 'aws-cluster-prov'
    
      yaml """
apiVersion: v1
kind: Pod
metadata:
labels:
  component: ci
spec:
  # Use service account that can deploy to all namespaces
  serviceAccountName: cicd
  containers:
  - name: eks
    image: cpattanayak/eks:latest
    command:
    - cat
    tty: true
 
  
"""
}
   }
   environment {
        AWS_ACCESS_KEY_ID = ''
		AWS_SECRET_ACCESS_KEY = ''
		AWS_DEFAULT_REGION=''
		
			
		
    }
   
   
  stages {
    
   
    stage('Provission aws') {
      steps {
        container('eks') {
		
          git 'https://github.com/CPattanayak/eks_provissioner.git'
         
          script {
                sh 'eksctl create cluster -f Privision-aws.yaml'
                sh 'kubectl get nodes -o wide'
              
               
              }
          
        }
      }
    }




	
          

    }
	
 
      
}