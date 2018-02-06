# Client

The client interface has been developed in a easy command line software.
The scope is to test all the possible REST calls provided by the process centric service.

## REST calls

- **GET /user/** => to get all the users
- **POST /user/** => to register a new user with a name
- **POST /user/{id}/artist/** => add a new artist to the user preferences
- **DELETE /user/{id}/artist/{name}** => remove an artist from the user preferences
- **GET /user/{id}/artist/recom** => to recommend similar artists from the user preferences
- **GET /user/{id}/event/{origin}** => to recommend events for the artists in the user preferences
- **GET /motivation** => to obtain a random quote
- **GET /user/{id}/artist** => to get user preferences
- **POST /user/{id}/evaluate** => to evaluate a recommended artist from the user
- **GET /user/{id}/evaluate** => to get all the evaluations given from a user to his recommended artists

## Some possible issues
Depending on the number of recommended artists and on the number of events available in the future, the requests can be slow to be processed (the computational cost should be O(nm) where n is the number of artists and m the number of events). Heroku have fixed a timeout for each request to 10-20 seconds so in some cases it is possible to get 503 errors for this reason
