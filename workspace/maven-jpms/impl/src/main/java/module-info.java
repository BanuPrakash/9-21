import com.cisco.api.LogService;
import com.cisco.api.impl.LogServiceStdOutImpl;

module impl {
    requires api;
    exports com.cisco.api.impl;
    provides LogService with LogServiceStdOutImpl;
}