package priv.samera2022.utils.yaml.config;

public class Message {
    private String as_system_prefix;
    private String as_system_empty_code;
    private String as_system_error_code;
    private String as_system_insufficient_permission;
    private String as_system_list_already_include;
    private String as_system_operation_completed;
    private String as_system_operation_failed;
    private String as_system_verify_operation;
    private String as_system_member_request_deny;

    private String minecraft_plugin_prefix;

    public Message(){

    }

    public void setAs_system_prefix(String as_system_prefix) {
        this.as_system_prefix = as_system_prefix;
    }
    public void setAs_system_empty_code(String as_system_empty_code) {
        this.as_system_empty_code = as_system_empty_code;
    }
    public void setAs_system_error_code(String as_system_error_code) {
        this.as_system_error_code = as_system_error_code;
    }
    public void setAs_system_insufficient_permission(String as_system_insufficient_permission) {
        this.as_system_insufficient_permission = as_system_insufficient_permission;
    }
    public void setAs_system_list_already_include(String as_system_list_already_include) {
        this.as_system_list_already_include = as_system_list_already_include;
    }
    public void setAs_system_operation_completed(String as_system_operation_completed) {
        this.as_system_operation_completed = as_system_operation_completed;
    }
    public void setAs_system_operation_failed(String as_system_operation_failed) {
        this.as_system_operation_failed = as_system_operation_failed;
    }
    public void setAs_system_verify_operation(String as_system_verify_operation) {
        this.as_system_verify_operation = as_system_verify_operation;
    }
    public void setAs_system_member_request_deny(String as_system_member_request_deny) {
        this.as_system_member_request_deny = as_system_member_request_deny;
    }
    public void setMinecraft_plugin_prefix(String minecraft_plugin_prefix) {
        this.minecraft_plugin_prefix = minecraft_plugin_prefix;
    }

    public String getAs_system_prefix() {
        return as_system_prefix;
    }
    public String getAs_system_empty_code() {
        return as_system_empty_code;
    }
    public String getAs_system_error_code() {
        return as_system_error_code;
    }
    public String getAs_system_insufficient_permission() {
        return as_system_insufficient_permission;
    }
    public String getAs_system_list_already_include() {
        return as_system_list_already_include;
    }
    public String getAs_system_operation_completed() {
        return as_system_operation_completed;
    }
    public String getAs_system_operation_failed() {
        return as_system_operation_failed;
    }
    public String getAs_system_verify_operation() {
        return as_system_verify_operation;
    }
    public String getAs_system_member_request_deny() {
        return as_system_member_request_deny;
    }
    public String getMinecraft_plugin_prefix() {
        return minecraft_plugin_prefix;
    }
}
