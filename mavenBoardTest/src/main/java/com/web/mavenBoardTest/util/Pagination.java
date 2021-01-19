package com.web.mavenBoardTest.util;

public class Pagination {

	private static final int PAGE_SIZE = 10;
	private static final int BLOCK_SIZE = 10;
	
	private int currentPage;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int rangePage;
	
	private int currentBlock;
	private int totalBlock;
	private int startBlock;
	private int endBlock;
	private int rangeBlock;
	
	private int prevPage;
	private int nextPage;
	
	public Pagination(int currentPage, int totalPage) {
		this.currentPage = currentPage;
		setTotalPage(totalPage);
		setRangePage(currentPage);
		
		this.currentBlock = 1;
		if (currentPage > BLOCK_SIZE){
			currentBlock = (int) Math.ceil((double) currentPage / BLOCK_SIZE);
		}
		setTotalBlock(totalPage);
		setRangeBlock(currentBlock);
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = (int) Math.ceil((double)totalPage / PAGE_SIZE);
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getRangePage() {
		return rangePage;
	}
	public void setRangePage(int currentPage) {
		this.startPage = (currentPage - 1) * PAGE_SIZE + 1;
		this.endPage = startPage + PAGE_SIZE - 1;
	}
	public int getCurrentBlock() {
		return currentBlock;
	}
	public void setCurrentBlock(int currentBlock) {
		this.currentBlock = currentBlock;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalPage) {
		this.totalBlock = (int) Math.ceil((double)totalPage / BLOCK_SIZE);
	}
	public int getStartBlock() {
		return startBlock;
	}
	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}
	public int getEndBlock() {
		return endBlock;
	}
	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}
	public int getRangeBlock() {
		return rangeBlock;
	}
	public void setRangeBlock(int currnetBlock) {
		this.startBlock = (currentBlock - 1) * BLOCK_SIZE + 1;
		this.endBlock = startBlock + BLOCK_SIZE - 1;
		
		if (endBlock > totalBlock){
			endBlock = totalBlock;
		}
		
		prevPage = currentPage - 1;
		nextPage = currentPage + 1;
		
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", totalPage=" + totalPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", rangePage=" + rangePage + ", currentBlock=" + currentBlock
				+ ", totalBlock=" + totalBlock + ", startBlock=" + startBlock + ", endBlock=" + endBlock
				+ ", rangeBlock=" + rangeBlock + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	}
}
