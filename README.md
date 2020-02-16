# eks_provissioner
project provision eks from jenkin pipeline
 1.create IAM role eks_cluster_role having EKS access
 2.create iAM user eks_cluster_user having AdministrationAccess
 3.create EC2->keypair->eks_cluster
 
environment variables need to set
  export AWS_ACCESS_KEY_ID=''
  export AWS_SECRET_ACCESS_KEY=''
  export AWS_DEFAULT_REGION=''
  
configuring to existing cluster
  aws eks --region region update-kubeconfig --name cluster_name
 
