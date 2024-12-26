package com.sitrc.connektify.posts_service.service;

import com.sitrc.connektify.posts_service.dto.PostCreateRequestDto;
import com.sitrc.connektify.posts_service.dto.PostDto;

import java.util.List;

public interface PostsService {

    PostDto createPost(PostCreateRequestDto postDto);

    PostDto getPostById(Long postId);

    List<PostDto> getAllPostsOfUser(Long userId);
}
