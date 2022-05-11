package michal.ulik.recruitmenttask.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionMessage {
    EXTERNAL_API_NOT_FOUND("External API not found. Code: "),
    NBP_RATE_CODE_NOT_FOUND("NbpRate not found. Code: "),
    NBP_TABLE_NOT_FOUND("NbpTable not found");

    private final String message;

    public String getMessage(String key) {
        return this.message + key;
    }

    public String getMessage() {
        return this.message;
    }
}
