package com.chunjae.spring7.dto;

public class PageConstructor {
    // 비즈니스 로직 변경 시 변경 가능
    private static final int pageSize = 10;
    private static final int blockSize = 5;
    // 외부에서 매개변수로 받는 state 성 필드
    private int currPage;
    private int totalCount;
    // 내부에서 계산하는 state 성 필드
    private int startRow;
    private int totalPage;
    private int startBlock;
    private int endBlock;
    private boolean prev;
    private boolean next;
    public PageConstructor(int currPage, int totalCount){
        this.currPage = currPage;
        this.totalCount=totalCount;
        calStartRow();
        calTotalPage();
        calBlock();
        definePrevNext();
    }
    private void calStartRow(){
        startRow = (currPage-1)*pageSize;
    }
    private void calTotalPage(){
        totalPage = (int) Math.ceil(totalCount/(double)pageSize);
    }
    private void calBlock(){
        startBlock = ((currPage-1)/blockSize)*blockSize+1;
        endBlock = startBlock+blockSize;
        if(endBlock>totalPage)
            endBlock=totalPage;
    }
    private void definePrevNext(){
        prev = (startBlock!=1);
        next = (endBlock<totalPage);
    }

    public static int getPageSize() {
        return pageSize;
    }

    public static int getBlockSize() {
        return blockSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getStartBlock() {
        return startBlock;
    }

    public int getEndBlock() {
        return endBlock;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

}
