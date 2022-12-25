// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  radar_command_api: "http://localhost:8888/RADAR-COMMAND-SERVICE/commands/radar",
  radar_query_api: "http://localhost:8888/RADAR-QUERY-SERVICE/queries/radar",
  immatriculation_query_api: "http://localhost:8888/IMMATRICULATION-QUERY-SERVICE/queries/immatriculation",
  immatriculation_command_api: "http://localhost:8888/IMMATRICULATION-COMMAND-SERVICE/commands",
  infraction_query_api: "http://localhost:8888/INFRACTION-QUERY-SERVICE/queries/infraction",
  infraction_command_api: "http://localhost:8888/INFRACTION-COMMAND-SERVICE/commands/infraction",
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
