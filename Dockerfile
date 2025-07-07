FROM payara/server-web:6.2025.1-jdk21
COPY target/gerenciador-pacientes.war $DEPLOY_DIR
