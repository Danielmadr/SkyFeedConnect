package com.Ada.SFCAuthenticator.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;


@Getter
public enum UserStatus {

  ACTIVE("A", "Ativo"),
  INACTIVE("I", "Inativo"),
  BANNED("B", "Banido"),
  DELETED("D", "Excluído"),
  PENDING("P", "Pendente");

  private String code;
  private String description;

  private UserStatus(String code, String description) {
    this.code = code;
    this.description = description;
  }

  @JsonValue
  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  @JsonCreator
  public static UserStatus fromCode(String code) {
    if (code.equals("A")) {
      return ACTIVE;
    } else if (code.equals("I")) {
      return INACTIVE;
    } else if (code.equals("D")) {
      return DELETED;
    } else if (code.equals("P")) {
      return PENDING;
    } else if (code.equals("B")) {
      return BANNED;
    } else {
      return null;
    }
  }
}