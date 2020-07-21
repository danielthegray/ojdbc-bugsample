# ojdbc-bugsample

This is a small program to showcase a strange error/bug in the Oracle JDBC driver.

To run the test, you first need an Oracle 19c database, running in a container
(for some reason, all driver versions seem to work well on Oracle 11g and 12c).

The database can be set up as follows:
1. Install Docker on your machine.
2. Clone https://github.com/oracle/docker-images to your machine.
3. Download the binary installer from Oracle Technology network
(https://www.oracle.com/database/technologies/oracle-database-software-downloads.html)
click on the Linux x86-64 option, and download the ZIP file.
4. Place this ZIP file inside the cloned repo, under
   `docker-images/OracleDatabase/SingleInstance/dockerfiles/19.3.0`.
5. Open a Terminal inside `docker-images/OracleDatabase/SingleInstance/dockerfiles` and
   run

       ./buildDockerImage.sh -v 19.3.0 -s -o

6. Run the docker image you have just created:
    
       docker run --name oracle19cse2 -p 1521:1521 -p 5500:5500 \
       -e ORACLE_SID=ORCLCDB -e ORACLE_PDB=XE -e ORACLE_PWD=system \
       -e ORACLE_CHARACTERSET=AL32UTF8 oracle/database:19.3.0-se2

This will set up a PDB and database password that match the test parameters.
Leave the terminal session active, since otherwise the database container will stop.

With the container running, just run the

     ./test.sh

and it will run the test with versions:
* 12.2.0.1
* 18.3.0.0
* 19.3.0.0

From version 19.3.0.0 onwards (19.6, 19.7), there is a strange timeout error and the message
"Got minus one from read call".
