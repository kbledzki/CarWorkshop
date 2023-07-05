create TABLE vehicle
(
    v_id                  char(36)     NOT NULL,
    created_at            datetime     NOT NULL,
    updated_at            datetime     NOT NULL,
    v_name                VARCHAR(255) NOT NULL,
    v_registration_number VARCHAR(255) NOT NULL,
    v_is_fixed            BIT(1)       NULL,
    v_color               INT          NULL,
    v_production_date     INT          NULL,
    CONSTRAINT pk_vehicle PRIMARY KEY (v_id)
);