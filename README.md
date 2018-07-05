# jbpmDatabaseLogin

1) Generate Hashing password using MD5 Algorithm and Base64 encoding
2) Add below configuration in standalone*.xml

<security-domain name="other" cache-type="default">
                    <authentication>
                        <login-module code="Database" flag="required">
                            <module-option name="dsJndiName" value="java:jboss/datasources/jbpmDS"/>
                            <module-option name="principalsQuery" value="select password from Users where user_id=?"/>
                            <module-option name="rolesQuery" value="select user_role, 'Roles' from roles where user_id=?"/>
							<module-option name="hashAlgorithm" value="MD5"/>
							<module-option name="hashEncoding" value="base64"/> 
                        </login-module>
                        <login-module code="org.kie.security.jaas.KieLoginModule" flag="optional" module="deployment.jbpm-console.war"/>
						 <login-module name="org.kie.security.jaas.KieLoginModule-3" code="org.kie.security.jaas.KieLoginModule" flag="optional" module="deployment.kie-server.war"/>  
                        <login-module name="org.kie.security.jaas.KieLoginModule-2" code="org.kie.security.jaas.KieLoginModule" flag="optional" module="deployment.jbpm-casemgmt.war"/>
                    </authentication>
                </security-domain>
