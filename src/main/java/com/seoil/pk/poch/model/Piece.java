package com.seoil.pk.poch.model;

public class Piece {

    // 체스 말의 종류를 나타내는 열거형
    public enum PieceType {
        WHITE_TOWER("wT"),
        BLACK_TOWER("bT"),
        WHITE_KING("wK"),
        BLACK_KING("bK");

        private final String code;

        PieceType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    private PieceType type;  // 체스 말의 종류
    private int x;           // 현재 위치 (x 좌표)
    private int y;           // 현재 위치 (y 좌표)

    // 생성자
    public Piece(PieceType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    // 게터 및 세터
    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // 체스 말의 이동 가능 여부를 판별하는 메서드
    public boolean isValidMove(int newX, int newY, Board board) {
        switch (this.type) {
            case WHITE_TOWER:
            case BLACK_TOWER:
                // 탑의 이동 규칙: 가로 또는 세로로만 이동 가능
                return (x == newX || y == newY);

            case WHITE_KING:
            case BLACK_KING:
                // 왕의 이동 규칙: 한 칸씩 상하좌우 또는 대각선 이동 가능
                return Math.abs(x - newX) <= 1 && Math.abs(y - newY) <= 1;

            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return "Piece{" +
                "type=" + type.getCode() +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
