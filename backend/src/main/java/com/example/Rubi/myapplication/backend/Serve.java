package com.example.Rubi.myapplication.backend;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Rubi on 03/04/2015.
 */

 public class Serve extends HttpServlet {
        private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse res)
                throws IOException {
            BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));
            blobstoreService.serve(blobKey, res);
        }
    }
