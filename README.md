# StarWarsAPI_Test_FrameWork

This is a framework designed to optimise testing of the Star Wars API. Providing the user with easy access 
to components of the API including the headers, status code and the body of the http response by modelling them
as Java objects. In order to perform the setup for the testbed, users will find the ConnectionManager class as a
means of establishing a connection with the API and an Injection class which is used to populate the data transfer
objects for each JSON body returned. In order to perform testing on the headers, status code and body of the 
response from the server the user may wish to make use of the HeadersTest, ConnectionTest and BodyTest classes,
respectively. 

Developers may wish to add functionailty to the framework by adding methods to the three test classes or by 
creating new classes in the 'shortcuts' directory. 