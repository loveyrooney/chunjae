package com.chunjae.mvc_mybatis.dto;

public class PageConstructor {
    private int currPage;
    private int totalCount;
    private int pageSize;
    private int blockSize;
    private int startRow;
    private int totalPage;
    private int startBlock;
    private int endBlock;
    private boolean prev;
    private boolean next;

    public PageConstructor(int currPage, int totalCount, int pageSize, int blockSize) {
        this.currPage = currPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.blockSize = blockSize;
        makeTotalPage();
        makeRow();
        makeBlock();
        makeNextPrev();
    }

    private void makeTotalPage(){
        totalPage = (int) Math.ceil(totalCount/(double)pageSize);
    }
    private void makeRow(){
        startRow = (currPage-1)*pageSize;
    }
    private void makeBlock(){
        startBlock = ((currPage-1)/blockSize)*blockSize+1;
        endBlock = startBlock+blockSize;
        if(endBlock>totalPage)
            endBlock=totalPage;
    }
    private void makeNextPrev(){
        prev = (startBlock!=1);
        next = (endBlock<totalPage);
    }

    public int getCurrPage() {
        return currPage;
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
