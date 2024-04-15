package org.iot.itty.user.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_tb")
public class UserEntity {
	@Id
	@Column(name = "user_code_pk")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userCodePk;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_phone_number")
	private String userPhoneNumber;

	@Column(name = "user_role")
	private String userRole;

	@Column(name = "user_nickname")
	private String userNickname;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "user_introduction")
	private String userIntroduction;

	@Column(name = "user_delete_status")
	private Integer userDeleteStatus;
}
