package com.example.ClinicalSystem.DTO;

import com.example.ClinicalSystem.model.OR;

public class OperationRoomDTO {

    private Long id;
    private int number;
    private String name;
    private boolean isAvailable;
    private String reserved;

    public OperationRoomDTO(Long id, int number, String name, boolean isAvailable, String reserved) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.isAvailable = isAvailable;
        this.reserved = reserved;
    }

    public OperationRoomDTO() {
        super();
        this.setReserved("No");
        this.setAvailable(false);
    }

    public OperationRoomDTO(OR room) {
        this(room.getId(), room.getNumber(), room.getName(), room.isAvailable(), room.getReserved());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }
}
