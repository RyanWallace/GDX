/*******************************************************************************
 * Copyright 2015 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.graphics.profiling;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;

/** @author Daniel Holderbaum
 * @author Jan Polák */
public class GL30Profiler extends GLProfiler implements GL30 {

	public final GL30 gl30;

	protected GL30Profiler (GL30 gl30) {
		this.gl30 = gl30;
	}
	
	private void check () {
		int error = gl30.glGetError();
		while (error != GL20.GL_NO_ERROR) {
			listener.onError(error);
			error = gl30.glGetError();
		}
	}

	
	public void glActiveTexture (int texture) {
		calls++;
		gl30.glActiveTexture(texture);
		check();
	}

	
	public void glBindTexture (int target, int texture) {
		textureBindings++;
		calls++;
		gl30.glBindTexture(target, texture);
		check();
	}

	
	public void glBlendFunc (int sfactor, int dfactor) {
		calls++;
		gl30.glBlendFunc(sfactor, dfactor);
		check();
	}

	
	public void glClear (int mask) {
		calls++;
		gl30.glClear(mask);
		check();
	}

	
	public void glClearColor (float red, float green, float blue, float alpha) {
		calls++;
		gl30.glClearColor(red, green, blue, alpha);
		check();
	}

	
	public void glClearDepthf (float depth) {
		calls++;
		gl30.glClearDepthf(depth);
		check();
	}

	
	public void glClearStencil (int s) {
		calls++;
		gl30.glClearStencil(s);
		check();
	}

	
	public void glColorMask (boolean red, boolean green, boolean blue, boolean alpha) {
		calls++;
		gl30.glColorMask(red, green, blue, alpha);
		check();
	}

	
	public void glCompressedTexImage2D (int target, int level, int internalformat, int width, int height, int border,
		int imageSize, Buffer data) {
		calls++;
		gl30.glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data);
		check();
	}

	
	public void glCompressedTexSubImage2D (int target, int level, int xoffset, int yoffset, int width, int height, int format,
		int imageSize, Buffer data) {
		calls++;
		gl30.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data);
		check();
	}

	
	public void glCopyTexImage2D (int target, int level, int internalformat, int x, int y, int width, int height, int border) {
		calls++;
		gl30.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border);
		check();
	}

	
	public void glCopyTexSubImage2D (int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
		calls++;
		gl30.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
		check();
	}

	
	public void glCullFace (int mode) {
		calls++;
		gl30.glCullFace(mode);
		check();
	}

	
	public void glDeleteTextures (int n, IntBuffer textures) {
		calls++;
		gl30.glDeleteTextures(n, textures);
		check();
	}

	
	public void glDeleteTexture (int texture) {
		calls++;
		gl30.glDeleteTexture(texture);
		check();
	}

	
	public void glDepthFunc (int func) {
		calls++;
		gl30.glDepthFunc(func);
		check();
	}

	
	public void glDepthMask (boolean flag) {
		calls++;
		gl30.glDepthMask(flag);
		check();
	}

	
	public void glDepthRangef (float zNear, float zFar) {
		calls++;
		gl30.glDepthRangef(zNear, zFar);
		check();
	}

	
	public void glDisable (int cap) {
		calls++;
		gl30.glDisable(cap);
		check();
	}

	
	public void glDrawArrays (int mode, int first, int count) {
		vertexCount.put(count);
		drawCalls++;
		calls++;
		gl30.glDrawArrays(mode, first, count);
		check();
	}

	
	public void glDrawElements (int mode, int count, int type, Buffer indices) {
		vertexCount.put(count);
		drawCalls++;
		calls++;
		gl30.glDrawElements(mode, count, type, indices);
		check();
	}

	
	public void glEnable (int cap) {
		calls++;
		gl30.glEnable(cap);
		check();
	}

	
	public void glFinish () {
		calls++;
		gl30.glFinish();
		check();
	}

	
	public void glFlush () {
		calls++;
		gl30.glFlush();
		check();
	}

	
	public void glFrontFace (int mode) {
		calls++;
		gl30.glFrontFace(mode);
		check();
	}

	
	public void glGenTextures (int n, IntBuffer textures) {
		calls++;
		gl30.glGenTextures(n, textures);
		check();
	}

	
	public int glGenTexture () {
		calls++;
		int result = gl30.glGenTexture();
		check();
		return result;
	}

	
	public int glGetError () {
		calls++;
		//Errors by glGetError are undetectable
		return gl30.glGetError();
	}

	
	public void glGetIntegerv (int pname, IntBuffer params) {
		calls++;
		gl30.glGetIntegerv(pname, params);
		check();
	}

	
	public String glGetString (int name) {
		calls++;
		String result = gl30.glGetString(name);
		check();
		return result;
	}

	
	public void glHint (int target, int mode) {
		calls++;
		gl30.glHint(target, mode);
		check();
	}

	
	public void glLineWidth (float width) {
		calls++;
		gl30.glLineWidth(width);
		check();
	}

	
	public void glPixelStorei (int pname, int param) {
		calls++;
		gl30.glPixelStorei(pname, param);
		check();
	}

	
	public void glPolygonOffset (float factor, float units) {
		calls++;
		gl30.glPolygonOffset(factor, units);
		check();
	}

	
	public void glReadPixels (int x, int y, int width, int height, int format, int type, Buffer pixels) {
		calls++;
		gl30.glReadPixels(x, y, width, height, format, type, pixels);
		check();
	}

	
	public void glScissor (int x, int y, int width, int height) {
		calls++;
		gl30.glScissor(x, y, width, height);
		check();
	}

	
	public void glStencilFunc (int func, int ref, int mask) {
		calls++;
		gl30.glStencilFunc(func, ref, mask);
		check();
	}

	
	public void glStencilMask (int mask) {
		calls++;
		gl30.glStencilMask(mask);
		check();
	}

	
	public void glStencilOp (int fail, int zfail, int zpass) {
		calls++;
		gl30.glStencilOp(fail, zfail, zpass);
		check();
	}

	
	public void glTexImage2D (int target, int level, int internalformat, int width, int height, int border, int format, int type,
		Buffer pixels) {
		calls++;
		gl30.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
		check();
	}

	
	public void glTexParameterf (int target, int pname, float param) {
		calls++;
		gl30.glTexParameterf(target, pname, param);
		check();
	}

	
	public void glTexSubImage2D (int target, int level, int xoffset, int yoffset, int width, int height, int format, int type,
		Buffer pixels) {
		calls++;
		gl30.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
		check();
	}

	
	public void glViewport (int x, int y, int width, int height) {
		calls++;
		gl30.glViewport(x, y, width, height);
		check();
	}

	
	public void glAttachShader (int program, int shader) {
		calls++;
		gl30.glAttachShader(program, shader);
		check();
	}

	
	public void glBindAttribLocation (int program, int index, String name) {
		calls++;
		gl30.glBindAttribLocation(program, index, name);
		check();
	}

	
	public void glBindBuffer (int target, int buffer) {
		calls++;
		gl30.glBindBuffer(target, buffer);
		check();
	}

	
	public void glBindFramebuffer (int target, int framebuffer) {
		calls++;
		gl30.glBindFramebuffer(target, framebuffer);
		check();
	}

	
	public void glBindRenderbuffer (int target, int renderbuffer) {
		calls++;
		gl30.glBindRenderbuffer(target, renderbuffer);
		check();
	}

	
	public void glBlendColor (float red, float green, float blue, float alpha) {
		calls++;
		gl30.glBlendColor(red, green, blue, alpha);
		check();
	}

	
	public void glBlendEquation (int mode) {
		calls++;
		gl30.glBlendEquation(mode);
		check();
	}

	
	public void glBlendEquationSeparate (int modeRGB, int modeAlpha) {
		calls++;
		gl30.glBlendEquationSeparate(modeRGB, modeAlpha);
		check();
	}

	
	public void glBlendFuncSeparate (int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
		calls++;
		gl30.glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
		check();
	}

	
	public void glBufferData (int target, int size, Buffer data, int usage) {
		calls++;
		gl30.glBufferData(target, size, data, usage);
		check();
	}

	
	public void glBufferSubData (int target, int offset, int size, Buffer data) {
		calls++;
		gl30.glBufferSubData(target, offset, size, data);
		check();
	}

	
	public int glCheckFramebufferStatus (int target) {
		calls++;
		int result = gl30.glCheckFramebufferStatus(target);
		check();
		return result;
	}

	
	public void glCompileShader (int shader) {
		calls++;
		gl30.glCompileShader(shader);
		check();
	}

	
	public int glCreateProgram () {
		calls++;
		int result = gl30.glCreateProgram();
		check();
		return result;
	}

	
	public int glCreateShader (int type) {
		calls++;
		int result = gl30.glCreateShader(type);
		check();
		return result;
	}

	
	public void glDeleteBuffer (int buffer) {
		calls++;
		gl30.glDeleteBuffer(buffer);
		check();
	}

	
	public void glDeleteBuffers (int n, IntBuffer buffers) {
		calls++;
		gl30.glDeleteBuffers(n, buffers);
		check();
	}

	
	public void glDeleteFramebuffer (int framebuffer) {
		calls++;
		gl30.glDeleteFramebuffer(framebuffer);
		check();
	}

	
	public void glDeleteFramebuffers (int n, IntBuffer framebuffers) {
		calls++;
		gl30.glDeleteFramebuffers(n, framebuffers);
		check();
	}

	
	public void glDeleteProgram (int program) {
		calls++;
		gl30.glDeleteProgram(program);
		check();
	}

	
	public void glDeleteRenderbuffer (int renderbuffer) {
		calls++;
		gl30.glDeleteRenderbuffer(renderbuffer);
		check();
	}

	
	public void glDeleteRenderbuffers (int n, IntBuffer renderbuffers) {
		calls++;
		gl30.glDeleteRenderbuffers(n, renderbuffers);
		check();
	}

	
	public void glDeleteShader (int shader) {
		calls++;
		gl30.glDeleteShader(shader);
		check();
	}

	
	public void glDetachShader (int program, int shader) {
		calls++;
		gl30.glDetachShader(program, shader);
		check();
	}

	
	public void glDisableVertexAttribArray (int index) {
		calls++;
		gl30.glDisableVertexAttribArray(index);
		check();
	}

	
	public void glDrawElements (int mode, int count, int type, int indices) {
		vertexCount.put(count);
		drawCalls++;
		calls++;
		gl30.glDrawElements(mode, count, type, indices);
		check();
	}

	
	public void glEnableVertexAttribArray (int index) {
		calls++;
		gl30.glEnableVertexAttribArray(index);
		check();
	}

	
	public void glFramebufferRenderbuffer (int target, int attachment, int renderbuffertarget, int renderbuffer) {
		calls++;
		gl30.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
		check();
	}

	
	public void glFramebufferTexture2D (int target, int attachment, int textarget, int texture, int level) {
		calls++;
		gl30.glFramebufferTexture2D(target, attachment, textarget, texture, level);
		check();
	}

	
	public int glGenBuffer () {
		calls++;
		int result = gl30.glGenBuffer();
		check();
		return result;
	}

	
	public void glGenBuffers (int n, IntBuffer buffers) {
		calls++;
		gl30.glGenBuffers(n, buffers);
		check();
	}

	
	public void glGenerateMipmap (int target) {
		calls++;
		gl30.glGenerateMipmap(target);
		check();
	}

	
	public int glGenFramebuffer () {
		calls++;
		int result = gl30.glGenFramebuffer();
		check();
		return result;
	}

	
	public void glGenFramebuffers (int n, IntBuffer framebuffers) {
		calls++;
		gl30.glGenFramebuffers(n, framebuffers);
		check();
	}

	
	public int glGenRenderbuffer () {
		calls++;
		int result = gl30.glGenRenderbuffer();
		check();
		return result;
	}

	
	public void glGenRenderbuffers (int n, IntBuffer renderbuffers) {
		calls++;
		gl30.glGenRenderbuffers(n, renderbuffers);
		check();
	}

	
	public String glGetActiveAttrib (int program, int index, IntBuffer size, Buffer type) {
		calls++;
		String result = gl30.glGetActiveAttrib(program, index, size, type);
		check();
		return result;
	}

	
	public String glGetActiveUniform (int program, int index, IntBuffer size, Buffer type) {
		calls++;
		String result = gl30.glGetActiveUniform(program, index, size, type);
		check();
		return result;
	}

	
	public void glGetAttachedShaders (int program, int maxcount, Buffer count, IntBuffer shaders) {
		calls++;
		gl30.glGetAttachedShaders(program, maxcount, count, shaders);
		check();
	}

	
	public int glGetAttribLocation (int program, String name) {
		calls++;
		int result = gl30.glGetAttribLocation(program, name);
		check();
		return result;
	}

	
	public void glGetBooleanv (int pname, Buffer params) {
		calls++;
		gl30.glGetBooleanv(pname, params);
		check();
	}

	
	public void glGetBufferParameteriv (int target, int pname, IntBuffer params) {
		calls++;
		gl30.glGetBufferParameteriv(target, pname, params);
		check();
	}

	
	public void glGetFloatv (int pname, FloatBuffer params) {
		calls++;
		gl30.glGetFloatv(pname, params);
		check();
	}

	
	public void glGetFramebufferAttachmentParameteriv (int target, int attachment, int pname, IntBuffer params) {
		calls++;
		gl30.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
		check();
	}

	
	public void glGetProgramiv (int program, int pname, IntBuffer params) {
		calls++;
		gl30.glGetProgramiv(program, pname, params);
		check();
	}

	
	public String glGetProgramInfoLog (int program) {
		calls++;
		String result = gl30.glGetProgramInfoLog(program);
		check();
		return result;
	}

	
	public void glGetRenderbufferParameteriv (int target, int pname, IntBuffer params) {
		calls++;
		gl30.glGetRenderbufferParameteriv(target, pname, params);
		check();
	}

	
	public void glGetShaderiv (int shader, int pname, IntBuffer params) {
		calls++;
		gl30.glGetShaderiv(shader, pname, params);
		check();
	}

	
	public String glGetShaderInfoLog (int shader) {
		calls++;
		String result = gl30.glGetShaderInfoLog(shader);
		check();
		return result;
	}

	
	public void glGetShaderPrecisionFormat (int shadertype, int precisiontype, IntBuffer range, IntBuffer precision) {
		calls++;
		gl30.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
		check();
	}

	
	public void glGetTexParameterfv (int target, int pname, FloatBuffer params) {
		calls++;
		gl30.glGetTexParameterfv(target, pname, params);
		check();
	}

	
	public void glGetTexParameteriv (int target, int pname, IntBuffer params) {
		calls++;
		gl30.glGetTexParameteriv(target, pname, params);
		check();
	}

	
	public void glGetUniformfv (int program, int location, FloatBuffer params) {
		calls++;
		gl30.glGetUniformfv(program, location, params);
		check();
	}

	
	public void glGetUniformiv (int program, int location, IntBuffer params) {
		calls++;
		gl30.glGetUniformiv(program, location, params);
		check();
	}

	
	public int glGetUniformLocation (int program, String name) {
		calls++;
		int result = gl30.glGetUniformLocation(program, name);
		check();
		return result;
	}

	
	public void glGetVertexAttribfv (int index, int pname, FloatBuffer params) {
		calls++;
		gl30.glGetVertexAttribfv(index, pname, params);
		check();
	}

	
	public void glGetVertexAttribiv (int index, int pname, IntBuffer params) {
		calls++;
		gl30.glGetVertexAttribiv(index, pname, params);
		check();
	}

	
	public void glGetVertexAttribPointerv (int index, int pname, Buffer pointer) {
		calls++;
		gl30.glGetVertexAttribPointerv(index, pname, pointer);
		check();
	}

	
	public boolean glIsBuffer (int buffer) {
		calls++;
		boolean result = gl30.glIsBuffer(buffer);
		check();
		return result;
	}

	
	public boolean glIsEnabled (int cap) {
		calls++;
		boolean result = gl30.glIsEnabled(cap);
		check();
		return result;
	}

	
	public boolean glIsFramebuffer (int framebuffer) {
		calls++;
		boolean result = gl30.glIsFramebuffer(framebuffer);
		check();
		return result;
	}

	
	public boolean glIsProgram (int program) {
		calls++;
		boolean result = gl30.glIsProgram(program);
		check();
		return result;
	}

	
	public boolean glIsRenderbuffer (int renderbuffer) {
		calls++;
		boolean result = gl30.glIsRenderbuffer(renderbuffer);
		check();
		return result;
	}

	
	public boolean glIsShader (int shader) {
		calls++;
		boolean result = gl30.glIsShader(shader);
		check();
		return result;
	}

	
	public boolean glIsTexture (int texture) {
		calls++;
		boolean result = gl30.glIsTexture(texture);
		check();
		return result;
	}

	
	public void glLinkProgram (int program) {
		calls++;
		gl30.glLinkProgram(program);
		check();
	}

	
	public void glReleaseShaderCompiler () {
		calls++;
		gl30.glReleaseShaderCompiler();
		check();
	}

	
	public void glRenderbufferStorage (int target, int internalformat, int width, int height) {
		calls++;
		gl30.glRenderbufferStorage(target, internalformat, width, height);
		check();
	}

	
	public void glSampleCoverage (float value, boolean invert) {
		calls++;
		gl30.glSampleCoverage(value, invert);
		check();
	}

	
	public void glShaderBinary (int n, IntBuffer shaders, int binaryformat, Buffer binary, int length) {
		calls++;
		gl30.glShaderBinary(n, shaders, binaryformat, binary, length);
		check();
	}

	
	public void glShaderSource (int shader, String string) {
		calls++;
		gl30.glShaderSource(shader, string);
		check();
	}

	
	public void glStencilFuncSeparate (int face, int func, int ref, int mask) {
		calls++;
		gl30.glStencilFuncSeparate(face, func, ref, mask);
		check();
	}

	
	public void glStencilMaskSeparate (int face, int mask) {
		calls++;
		gl30.glStencilMaskSeparate(face, mask);
		check();
	}

	
	public void glStencilOpSeparate (int face, int fail, int zfail, int zpass) {
		calls++;
		gl30.glStencilOpSeparate(face, fail, zfail, zpass);
		check();
	}

	
	public void glTexParameterfv (int target, int pname, FloatBuffer params) {
		calls++;
		gl30.glTexParameterfv(target, pname, params);
		check();
	}

	
	public void glTexParameteri (int target, int pname, int param) {
		calls++;
		gl30.glTexParameteri(target, pname, param);
		check();
	}

	
	public void glTexParameteriv (int target, int pname, IntBuffer params) {
		calls++;
		gl30.glTexParameteriv(target, pname, params);
		check();
	}

	
	public void glUniform1f (int location, float x) {
		calls++;
		gl30.glUniform1f(location, x);
		check();
	}

	
	public void glUniform1fv (int location, int count, FloatBuffer v) {
		calls++;
		gl30.glUniform1fv(location, count, v);
		check();
	}

	
	public void glUniform1fv (int location, int count, float[] v, int offset) {
		calls++;
		gl30.glUniform1fv(location, count, v, offset);
		check();
	}

	
	public void glUniform1i (int location, int x) {
		calls++;
		gl30.glUniform1i(location, x);
		check();
	}

	
	public void glUniform1iv (int location, int count, IntBuffer v) {
		calls++;
		gl30.glUniform1iv(location, count, v);
		check();
	}

	
	public void glUniform1iv (int location, int count, int[] v, int offset) {
		calls++;
		gl30.glUniform1iv(location, count, v, offset);
		check();
	}

	
	public void glUniform2f (int location, float x, float y) {
		calls++;
		gl30.glUniform2f(location, x, y);
		check();
	}

	
	public void glUniform2fv (int location, int count, FloatBuffer v) {
		calls++;
		gl30.glUniform2fv(location, count, v);
		check();
	}

	
	public void glUniform2fv (int location, int count, float[] v, int offset) {
		calls++;
		gl30.glUniform2fv(location, count, v, offset);
		check();
	}

	
	public void glUniform2i (int location, int x, int y) {
		calls++;
		gl30.glUniform2i(location, x, y);
		check();
	}

	
	public void glUniform2iv (int location, int count, IntBuffer v) {
		calls++;
		gl30.glUniform2iv(location, count, v);
		check();
	}

	
	public void glUniform2iv (int location, int count, int[] v, int offset) {
		calls++;
		gl30.glUniform2iv(location, count, v, offset);
		check();
	}

	
	public void glUniform3f (int location, float x, float y, float z) {
		calls++;
		gl30.glUniform3f(location, x, y, z);
		check();
	}

	
	public void glUniform3fv (int location, int count, FloatBuffer v) {
		calls++;
		gl30.glUniform3fv(location, count, v);
		check();
	}

	
	public void glUniform3fv (int location, int count, float[] v, int offset) {
		calls++;
		gl30.glUniform3fv(location, count, v, offset);
		check();
	}

	
	public void glUniform3i (int location, int x, int y, int z) {
		calls++;
		gl30.glUniform3i(location, x, y, z);
		check();
	}

	
	public void glUniform3iv (int location, int count, IntBuffer v) {
		calls++;
		gl30.glUniform3iv(location, count, v);
		check();
	}

	
	public void glUniform3iv (int location, int count, int[] v, int offset) {
		calls++;
		gl30.glUniform3iv(location, count, v, offset);
		check();
	}

	
	public void glUniform4f (int location, float x, float y, float z, float w) {
		calls++;
		gl30.glUniform4f(location, x, y, z, w);
		check();
	}

	
	public void glUniform4fv (int location, int count, FloatBuffer v) {
		calls++;
		gl30.glUniform4fv(location, count, v);
		check();
	}

	
	public void glUniform4fv (int location, int count, float[] v, int offset) {
		calls++;
		gl30.glUniform4fv(location, count, v, offset);
		check();
	}

	
	public void glUniform4i (int location, int x, int y, int z, int w) {
		calls++;
		gl30.glUniform4i(location, x, y, z, w);
		check();
	}

	
	public void glUniform4iv (int location, int count, IntBuffer v) {
		calls++;
		gl30.glUniform4iv(location, count, v);
		check();
	}

	
	public void glUniform4iv (int location, int count, int[] v, int offset) {
		calls++;
		gl30.glUniform4iv(location, count, v, offset);
		check();
	}

	
	public void glUniformMatrix2fv (int location, int count, boolean transpose, FloatBuffer value) {
		calls++;
		gl30.glUniformMatrix2fv(location, count, transpose, value);
		check();
	}

	
	public void glUniformMatrix2fv (int location, int count, boolean transpose, float[] value, int offset) {
		calls++;
		gl30.glUniformMatrix2fv(location, count, transpose, value, offset);
		check();
	}

	
	public void glUniformMatrix3fv (int location, int count, boolean transpose, FloatBuffer value) {
		calls++;
		gl30.glUniformMatrix3fv(location, count, transpose, value);
		check();
	}

	
	public void glUniformMatrix3fv (int location, int count, boolean transpose, float[] value, int offset) {
		calls++;
		gl30.glUniformMatrix3fv(location, count, transpose, value, offset);
		check();
	}

	
	public void glUniformMatrix4fv (int location, int count, boolean transpose, FloatBuffer value) {
		calls++;
		gl30.glUniformMatrix4fv(location, count, transpose, value);
		check();
	}

	
	public void glUniformMatrix4fv (int location, int count, boolean transpose, float[] value, int offset) {
		calls++;
		gl30.glUniformMatrix4fv(location, count, transpose, value, offset);
		check();
	}

	
	public void glUseProgram (int program) {
		shaderSwitches++;
		calls++;
		gl30.glUseProgram(program);
		check();
	}

	
	public void glValidateProgram (int program) {
		calls++;
		gl30.glValidateProgram(program);
		check();
	}

	
	public void glVertexAttrib1f (int indx, float x) {
		calls++;
		gl30.glVertexAttrib1f(indx, x);
		check();
	}

	
	public void glVertexAttrib1fv (int indx, FloatBuffer values) {
		calls++;
		gl30.glVertexAttrib1fv(indx, values);
		check();
	}

	
	public void glVertexAttrib2f (int indx, float x, float y) {
		calls++;
		gl30.glVertexAttrib2f(indx, x, y);
		check();
	}

	
	public void glVertexAttrib2fv (int indx, FloatBuffer values) {
		calls++;
		gl30.glVertexAttrib2fv(indx, values);
		check();
	}

	
	public void glVertexAttrib3f (int indx, float x, float y, float z) {
		calls++;
		gl30.glVertexAttrib3f(indx, x, y, z);
		check();
	}

	
	public void glVertexAttrib3fv (int indx, FloatBuffer values) {
		calls++;
		gl30.glVertexAttrib3fv(indx, values);
		check();
	}

	
	public void glVertexAttrib4f (int indx, float x, float y, float z, float w) {
		calls++;
		gl30.glVertexAttrib4f(indx, x, y, z, w);
		check();
	}

	
	public void glVertexAttrib4fv (int indx, FloatBuffer values) {
		calls++;
		gl30.glVertexAttrib4fv(indx, values);
		check();
	}

	
	public void glVertexAttribPointer (int indx, int size, int type, boolean normalized, int stride, Buffer ptr) {
		calls++;
		gl30.glVertexAttribPointer(indx, size, type, normalized, stride, ptr);
		check();
	}

	
	public void glVertexAttribPointer (int indx, int size, int type, boolean normalized, int stride, int ptr) {
		calls++;
		gl30.glVertexAttribPointer(indx, size, type, normalized, stride, ptr);
		check();
	}

	// GL30 Unique

	
	public void glReadBuffer (int mode) {
		calls++;
		gl30.glReadBuffer(mode);
		check();
	}

	
	public void glDrawRangeElements (int mode, int start, int end, int count, int type, Buffer indices) {
		vertexCount.put(count);
		drawCalls++;
		calls++;
		gl30.glDrawRangeElements(mode, start, end, count, type, indices);
		check();
	}

	
	public void glDrawRangeElements (int mode, int start, int end, int count, int type, int offset) {
		vertexCount.put(count);
		drawCalls++;
		calls++;
		gl30.glDrawRangeElements(mode, start, end, count, type, offset);
		check();
	}

	
	public void glTexImage3D (int target, int level, int internalformat, int width, int height, int depth, int border, int format,
		int type, Buffer pixels) {
		calls++;
		gl30.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, pixels);
		check();
	}

	
	public void glTexImage3D (int target, int level, int internalformat, int width, int height, int depth, int border, int format,
		int type, int offset) {
		calls++;
		gl30.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, offset);
		check();
	}

	
	public void glTexSubImage3D (int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth,
		int format, int type, Buffer pixels) {
		calls++;
		gl30.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
		check();
	}

	
	public void glTexSubImage3D (int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth,
		int format, int type, int offset) {
		calls++;
		gl30.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, offset);
		check();
	}

	
	public void glCopyTexSubImage3D (int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width,
		int height) {
		calls++;
		gl30.glCopyTexSubImage3D(target, level, xoffset, yoffset, zoffset, x, y, width, height);
		check();
	}

	
	public void glGenQueries (int n, int[] ids, int offset) {
		calls++;
		gl30.glGenQueries(n, ids, offset);
		check();
	}

	
	public void glGenQueries (int n, IntBuffer ids) {
		calls++;
		gl30.glGenQueries(n, ids);
		check();
	}

	
	public void glDeleteQueries (int n, int[] ids, int offset) {
		calls++;
		gl30.glDeleteQueries(n, ids, offset);
		check();
	}

	
	public void glDeleteQueries (int n, IntBuffer ids) {
		calls++;
		gl30.glDeleteQueries(n, ids);
		check();
	}

	
	public boolean glIsQuery (int id) {
		calls++;
		final boolean result = gl30.glIsQuery(id);
		check();
		return result;
	}

	
	public void glBeginQuery (int target, int id) {
		calls++;
		gl30.glBeginQuery(target, id);
		check();
	}

	
	public void glEndQuery (int target) {
		calls++;
		gl30.glEndQuery(target);
		check();
	}

	
	public void glGetQueryiv (int target, int pname, IntBuffer params) {
		calls++;
		gl30.glGetQueryiv(target, pname, params);
		check();
	}

	
	public void glGetQueryObjectuiv (int id, int pname, IntBuffer params) {
		calls++;
		gl30.glGetQueryObjectuiv(id, pname, params);
		check();
	}

	
	public boolean glUnmapBuffer (int target) {
		calls++;
		final boolean result = gl30.glUnmapBuffer(target);
		check();
		return result;
	}

	
	public Buffer glGetBufferPointerv (int target, int pname) {
		calls++;
		final Buffer result = gl30.glGetBufferPointerv(target, pname);
		check();
		return result;
	}

	
	public void glDrawBuffers (int n, IntBuffer bufs) {
		drawCalls++;
		calls++;
		gl30.glDrawBuffers(n, bufs);
		check();
	}

	
	public void glUniformMatrix2x3fv (int location, int count, boolean transpose, FloatBuffer value) {
		calls++;
		gl30.glUniformMatrix2x3fv(location, count, transpose, value);
		check();
	}

	
	public void glUniformMatrix3x2fv (int location, int count, boolean transpose, FloatBuffer value) {
		calls++;
		gl30.glUniformMatrix3x2fv(location, count, transpose, value);
		check();
	}

	
	public void glUniformMatrix2x4fv (int location, int count, boolean transpose, FloatBuffer value) {
		calls++;
		gl30.glUniformMatrix2x4fv(location, count, transpose, value);
		check();
	}

	
	public void glUniformMatrix4x2fv (int location, int count, boolean transpose, FloatBuffer value) {
		calls++;
		gl30.glUniformMatrix4x2fv(location, count, transpose, value);
		check();
	}

	
	public void glUniformMatrix3x4fv (int location, int count, boolean transpose, FloatBuffer value) {
		calls++;
		gl30.glUniformMatrix3x4fv(location, count, transpose, value);
		check();
	}

	
	public void glUniformMatrix4x3fv (int location, int count, boolean transpose, FloatBuffer value) {
		calls++;
		gl30.glUniformMatrix4x3fv(location, count, transpose, value);
		check();
	}

	
	public void glBlitFramebuffer (int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1,
		int mask, int filter) {
		calls++;
		gl30.glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
		check();
	}

	
	public void glRenderbufferStorageMultisample (int target, int samples, int internalformat, int width, int height) {
		calls++;
		gl30.glRenderbufferStorageMultisample(target, samples, internalformat, width, height);
		check();
	}

	
	public void glFramebufferTextureLayer (int target, int attachment, int texture, int level, int layer) {
		calls++;
		gl30.glFramebufferTextureLayer(target, attachment, texture, level, layer);
		check();
	}

	
	public void glFlushMappedBufferRange (int target, int offset, int length) {
		calls++;
		gl30.glFlushMappedBufferRange(target, offset, length);
		check();
	}

	
	public void glBindVertexArray (int array) {
		calls++;
		gl30.glBindVertexArray(array);
		check();
	}

	
	public void glDeleteVertexArrays (int n, int[] arrays, int offset) {
		calls++;
		gl30.glDeleteVertexArrays(n, arrays, offset);
		check();
	}

	
	public void glDeleteVertexArrays (int n, IntBuffer arrays) {
		calls++;
		gl30.glDeleteVertexArrays(n, arrays);
		check();
	}

	
	public void glGenVertexArrays (int n, int[] arrays, int offset) {
		calls++;
		gl30.glGenVertexArrays(n, arrays, offset);
		check();
	}

	
	public void glGenVertexArrays (int n, IntBuffer arrays) {
		calls++;
		gl30.glGenVertexArrays(n, arrays);
		check();
	}

	
	public boolean glIsVertexArray (int array) {
		calls++;
		final boolean result = gl30.glIsVertexArray(array);
		check();
		return result;
	}

	
	public void glBeginTransformFeedback (int primitiveMode) {
		calls++;
		gl30.glBeginTransformFeedback(primitiveMode);
		check();
	}

	
	public void glEndTransformFeedback () {
		calls++;
		gl30.glEndTransformFeedback();
		check();
	}

	
	public void glBindBufferRange (int target, int index, int buffer, int offset, int size) {
		calls++;
		gl30.glBindBufferRange(target, index, buffer, offset, size);
		check();
	}

	
	public void glBindBufferBase (int target, int index, int buffer) {
		calls++;
		gl30.glBindBufferBase(target, index, buffer);
		check();
	}

	
	public void glTransformFeedbackVaryings (int program, String[] varyings, int bufferMode) {
		calls++;
		gl30.glTransformFeedbackVaryings(program, varyings, bufferMode);
		check();
	}

	
	public void glVertexAttribIPointer (int index, int size, int type, int stride, int offset) {
		calls++;
		gl30.glVertexAttribIPointer(index, size, type, stride, offset);
		check();
	}

	
	public void glGetVertexAttribIiv (int index, int pname, IntBuffer params) {
		calls++;
		gl30.glGetVertexAttribIiv(index, pname, params);
		check();
	}

	
	public void glGetVertexAttribIuiv (int index, int pname, IntBuffer params) {
		calls++;
		gl30.glGetVertexAttribIuiv(index, pname, params);
		check();
	}

	
	public void glVertexAttribI4i (int index, int x, int y, int z, int w) {
		calls++;
		gl30.glVertexAttribI4i(index, x, y, z, w);
		check();
	}

	
	public void glVertexAttribI4ui (int index, int x, int y, int z, int w) {
		calls++;
		gl30.glVertexAttribI4ui(index, x, y, z, w);
		check();
	}

	
	public void glGetUniformuiv (int program, int location, IntBuffer params) {
		calls++;
		gl30.glGetUniformuiv(program, location, params);
		check();
	}

	
	public int glGetFragDataLocation (int program, String name) {
		calls++;
		final int result = gl30.glGetFragDataLocation(program, name);
		check();
		return result;
	}

	
	public void glUniform1uiv (int location, int count, IntBuffer value) {
		calls++;
		gl30.glUniform1uiv(location, count, value);
		check();
	}

	
	public void glUniform3uiv (int location, int count, IntBuffer value) {
		calls++;
		gl30.glUniform3uiv(location, count, value);
		check();
	}

	
	public void glUniform4uiv (int location, int count, IntBuffer value) {
		calls++;
		gl30.glUniform4uiv(location, count, value);
		check();
	}

	
	public void glClearBufferiv (int buffer, int drawbuffer, IntBuffer value) {
		calls++;
		gl30.glClearBufferiv(buffer, drawbuffer, value);
		check();
	}

	
	public void glClearBufferuiv (int buffer, int drawbuffer, IntBuffer value) {
		calls++;
		gl30.glClearBufferuiv(buffer, drawbuffer, value);
		check();
	}

	
	public void glClearBufferfv (int buffer, int drawbuffer, FloatBuffer value) {
		calls++;
		gl30.glClearBufferfv(buffer, drawbuffer, value);
		check();
	}

	
	public void glClearBufferfi (int buffer, int drawbuffer, float depth, int stencil) {
		calls++;
		gl30.glClearBufferfi(buffer, drawbuffer, depth, stencil);
		check();
	}

	
	public String glGetStringi (int name, int index) {
		calls++;
		final String result = gl30.glGetStringi(name, index);
		check();
		return result;
	}

	
	public void glCopyBufferSubData (int readTarget, int writeTarget, int readOffset, int writeOffset, int size) {
		calls++;
		gl30.glCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size);
		check();
	}

	
	public void glGetUniformIndices (int program, String[] uniformNames, IntBuffer uniformIndices) {
		calls++;
		gl30.glGetUniformIndices(program, uniformNames, uniformIndices);
		check();
	}

	
	public void glGetActiveUniformsiv (int program, int uniformCount, IntBuffer uniformIndices, int pname, IntBuffer params) {
		calls++;
		gl30.glGetActiveUniformsiv(program, uniformCount, uniformIndices, pname, params);
		check();
	}

	
	public int glGetUniformBlockIndex (int program, String uniformBlockName) {
		calls++;
		final int result = gl30.glGetUniformBlockIndex(program, uniformBlockName);
		check();
		return result;
	}

	
	public void glGetActiveUniformBlockiv (int program, int uniformBlockIndex, int pname, IntBuffer params) {
		calls++;
		gl30.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
		check();
	}

	
	public void glGetActiveUniformBlockName (int program, int uniformBlockIndex, Buffer length, Buffer uniformBlockName) {
		calls++;
		gl30.glGetActiveUniformBlockName(program, uniformBlockIndex, length, uniformBlockName);
		check();
	}

	
	public String glGetActiveUniformBlockName (int program, int uniformBlockIndex) {
		calls++;
		final String result = gl30.glGetActiveUniformBlockName(program, uniformBlockIndex);
		check();
		return result;
	}

	
	public void glUniformBlockBinding (int program, int uniformBlockIndex, int uniformBlockBinding) {
		calls++;
		gl30.glUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding);
		check();
	}

	
	public void glDrawArraysInstanced (int mode, int first, int count, int instanceCount) {
		vertexCount.put(count);
		drawCalls++;
		calls++;
		gl30.glDrawArraysInstanced(mode, first, count, instanceCount);
		check();
	}

	
	public void glDrawElementsInstanced (int mode, int count, int type, int indicesOffset, int instanceCount) {
		vertexCount.put(count);
		drawCalls++;
		calls++;
		gl30.glDrawElementsInstanced(mode, count, type, indicesOffset, instanceCount);
		check();
	}

	
	public void glGetInteger64v (int pname, LongBuffer params) {
		calls++;
		gl30.glGetInteger64v(pname, params);
		check();
	}

	
	public void glGetBufferParameteri64v (int target, int pname, LongBuffer params) {
		calls++;
		gl30.glGetBufferParameteri64v(target, pname, params);
		check();
	}

	
	public void glGenSamplers (int count, int[] samplers, int offset) {
		calls++;
		gl30.glGenSamplers(count, samplers, offset);
		check();
	}

	
	public void glGenSamplers (int count, IntBuffer samplers) {
		calls++;
		gl30.glGenSamplers(count, samplers);
		check();
	}

	
	public void glDeleteSamplers (int count, int[] samplers, int offset) {
		calls++;
		gl30.glDeleteSamplers(count, samplers, offset);
		check();
	}

	
	public void glDeleteSamplers (int count, IntBuffer samplers) {
		calls++;
		gl30.glDeleteSamplers(count, samplers);
		check();
	}

	
	public boolean glIsSampler (int sampler) {
		calls++;
		final boolean result = gl30.glIsSampler(sampler);
		check();
		return result;
	}

	
	public void glBindSampler (int unit, int sampler) {
		calls++;
		gl30.glBindSampler(unit, sampler);
		check();
	}

	
	public void glSamplerParameteri (int sampler, int pname, int param) {
		calls++;
		gl30.glSamplerParameteri(sampler, pname, param);
		check();
	}

	
	public void glSamplerParameteriv (int sampler, int pname, IntBuffer param) {
		calls++;
		gl30.glSamplerParameteriv(sampler, pname, param);
		check();
	}

	
	public void glSamplerParameterf (int sampler, int pname, float param) {
		calls++;
		gl30.glSamplerParameterf(sampler, pname, param);
		check();
	}

	
	public void glSamplerParameterfv (int sampler, int pname, FloatBuffer param) {
		calls++;
		gl30.glSamplerParameterfv(sampler, pname, param);
		check();
	}

	
	public void glGetSamplerParameteriv (int sampler, int pname, IntBuffer params) {
		calls++;
		gl30.glGetSamplerParameteriv(sampler, pname, params);
		check();
	}

	
	public void glGetSamplerParameterfv (int sampler, int pname, FloatBuffer params) {
		calls++;
		gl30.glGetSamplerParameterfv(sampler, pname, params);
		check();
	}

	
	public void glVertexAttribDivisor (int index, int divisor) {
		calls++;
		gl30.glVertexAttribDivisor(index, divisor);
		check();
	}

	
	public void glBindTransformFeedback (int target, int id) {
		calls++;
		gl30.glBindTransformFeedback(target, id);
		check();
	}

	
	public void glDeleteTransformFeedbacks (int n, int[] ids, int offset) {
		calls++;
		gl30.glDeleteTransformFeedbacks(n, ids, offset);
		check();
	}

	
	public void glDeleteTransformFeedbacks (int n, IntBuffer ids) {
		calls++;
		gl30.glDeleteTransformFeedbacks(n, ids);
		check();
	}

	
	public void glGenTransformFeedbacks (int n, int[] ids, int offset) {
		calls++;
		gl30.glGenTransformFeedbacks(n, ids, offset);
		check();
	}

	
	public void glGenTransformFeedbacks (int n, IntBuffer ids) {
		calls++;
		gl30.glGenTransformFeedbacks(n, ids);
		check();
	}

	
	public boolean glIsTransformFeedback (int id) {
		calls++;
		final boolean result = gl30.glIsTransformFeedback(id);
		check();
		return result;
	}

	
	public void glPauseTransformFeedback () {
		calls++;
		gl30.glPauseTransformFeedback();
		check();
	}

	
	public void glResumeTransformFeedback () {
		calls++;
		gl30.glResumeTransformFeedback();
		check();
	}

	
	public void glProgramParameteri (int program, int pname, int value) {
		calls++;
		gl30.glProgramParameteri(program, pname, value);
		check();
	}

	
	public void glInvalidateFramebuffer (int target, int numAttachments, IntBuffer attachments) {
		calls++;
		gl30.glInvalidateFramebuffer(target, numAttachments, attachments);
		check();
	}

	
	public void glInvalidateSubFramebuffer (int target, int numAttachments, IntBuffer attachments, int x, int y, int width,
		int height) {
		calls++;
		gl30.glInvalidateSubFramebuffer(target, numAttachments, attachments, x, y, width, height);
		check();
	}
}
