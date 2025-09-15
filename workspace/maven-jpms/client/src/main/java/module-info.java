module client {
    requires api; // just interface not hard coded impl requires
    // requires impl; // not required
    uses com.cisco.api.LogService; // uses the interface, not hard coded impl
}